package com.detrasoft.historapp.auth.domain.services.crud;

import com.detrasoft.historapp.auth.domain.entities.ProfileRole;
import com.detrasoft.historapp.auth.domain.repositories.ProfileRoleRepository;
import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileRoleCRUDService extends GenericCRUDService<ProfileRole> {

    public ProfileRoleCRUDService(ProfileRoleRepository repository) {
        super(repository);
    }

    @Autowired
    protected RoleCRUDService roleCRUDService;
    @Autowired
    protected ProfileCRUDService profileCRUDService;

    @Override
    protected void beforeInsert(ProfileRole entity) {
        entity.setRole(roleCRUDService.findById(entity.getRole().getId()));
        entity.setProfile(profileCRUDService.findById(entity.getProfile().getId()));
    }
}
