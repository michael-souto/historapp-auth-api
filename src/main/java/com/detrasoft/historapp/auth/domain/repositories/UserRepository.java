package com.detrasoft.historapp.auth.domain.repositories;

import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericCRUDRepository<User> {
    Optional<User> findByEmail(String email);

    Optional<User> findByCode(String code);
}
