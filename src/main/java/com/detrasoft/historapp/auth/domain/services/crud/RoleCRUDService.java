package com.detrasoft.historapp.auth.domain.services.crud;

import com.detrasoft.historapp.auth.domain.entities.Role;
import com.detrasoft.historapp.auth.domain.repositories.RoleRepository;
import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import org.springframework.stereotype.Service;

@Service
public class RoleCRUDService extends GenericCRUDService<Role> {

    public RoleCRUDService(RoleRepository repository) {
        super(repository);
    }
}
