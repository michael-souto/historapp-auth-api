package com.detrasoft.historapp.auth.domain.repositories;

import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import com.detrasoft.historapp.auth.domain.entities.Profile;
import com.detrasoft.historapp.auth.domain.entities.ProfileRole;
import com.detrasoft.historapp.auth.domain.entities.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRoleRepository  extends GenericCRUDRepository<ProfileRole> {
    Optional<ProfileRole> findByRoleAndProfile(Role role, Profile profile);
}
