package com.detrasoft.historapp.auth.domain.services.crud.user;

import com.detrasoft.historapp.auth.domain.entities.TypeUser;
import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.framework.crud.services.crud.GenericInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInsertService extends GenericInsertService<User> {

    @Autowired
    public UserInsertService(UserRepository repository) {
        super(repository);
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void beforeInsert(User entity) {

        // Encoding password
        if (entity.getPassword() != null) {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        }

        entity.setIdDetrasoft(1L);

        if (entity.getType() == null) {
            entity.setType(TypeUser.Default);
        }
    }
}
