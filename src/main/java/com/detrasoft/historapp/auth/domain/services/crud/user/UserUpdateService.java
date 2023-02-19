package com.detrasoft.historapp.auth.domain.services.crud.user;

import com.detrasoft.historapp.auth.domain.entities.TypeUser;
import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.framework.crud.services.crud.GenericUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateService extends GenericUpdateService<User> {

    @Autowired
    public UserUpdateService(UserRepository repository) {
        super(repository);
    }

    @Override
    protected void beforeUpdate(User entity) {
        entity.setIdDetrasoft(1L);
        if (entity.getType() == null) {
            entity.setType(TypeUser.Default);
        }
    }
}