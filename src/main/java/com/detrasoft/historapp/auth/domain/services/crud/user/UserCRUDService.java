package com.detrasoft.historapp.auth.domain.services.crud.user;

import com.detrasoft.historapp.auth.domain.entities.TypeUser;
import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.framework.crud.entities.GenericEntity;
import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import com.detrasoft.framework.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserCRUDService extends GenericCRUDService<User> {

    public UserCRUDService(UserRepository repository) {
        super(repository);
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void beforeInsert(User entity) { setDefaultData(entity); }

    @Override
    protected void beforeUpdate(User entity) {
        setDefaultData(entity);
    }

    private void setDefaultData(User entity) {
        entity.setIdDetrasoft(1L);
        if (entity.getType() == null) {
            entity.setType(TypeUser.Default);
        }
    }

    public GenericEntity finUserdByCode(String id) {
        return ((UserRepository)repository).findByCode(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
