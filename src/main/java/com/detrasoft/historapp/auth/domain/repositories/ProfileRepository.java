package com.detrasoft.historapp.auth.domain.repositories;

import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import com.detrasoft.historapp.auth.domain.entities.Profile;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends GenericCRUDRepository<Profile> {
}
