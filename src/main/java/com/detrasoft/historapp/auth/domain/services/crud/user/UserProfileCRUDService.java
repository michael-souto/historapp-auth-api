package com.detrasoft.historapp.auth.domain.services.crud.user;

import com.detrasoft.historapp.auth.domain.entities.UserProfile;
import com.detrasoft.historapp.auth.domain.repositories.UserProfileRepository;
import com.detrasoft.historapp.auth.domain.services.crud.ProfileCRUDService;
import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileCRUDService extends GenericCRUDService<UserProfile> {

    public UserProfileCRUDService(UserProfileRepository repository) {
        super(repository);
    }

    @Autowired
    protected UserCRUDService userCRUDService;
    @Autowired
    protected ProfileCRUDService profileCRUDService;

    @Override
    protected void beforeInsert(UserProfile entity) {
        entity.setUser(userCRUDService.findById(entity.getUser().getId()));
        entity.setProfile(profileCRUDService.findById(entity.getProfile().getId()));
    }
}
