package com.detrasoft.historapp.auth.domain.services.security;

import com.detrasoft.historapp.auth.domain.repositories.UserProfileRepository;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(() ->
        {
            logger.error("User not found:" + username);
            return new UsernameNotFoundException("User not found");
        });
    }
}
