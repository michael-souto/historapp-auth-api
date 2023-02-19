package com.detrasoft.historapp.auth.domain.repositories;

import com.detrasoft.historapp.auth.domain.entities.Role;
import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends GenericCRUDRepository<Role> {

    Role findByCode(String code);
}
