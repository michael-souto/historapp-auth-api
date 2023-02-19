package com.detrasoft.historapp.auth.domain.repositories;

import com.detrasoft.historapp.auth.domain.entities.Profile;
import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.historapp.auth.domain.entities.UserProfile;
import com.detrasoft.framework.crud.repositories.GenericCRUDRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends GenericCRUDRepository<UserProfile> {

    @Query(value = "select u FROM UserProfile u INNER JOIN u.profile prof WHERE u.user.id = :userId")
    Page<UserProfile> findByUserId(Long userId, Pageable pageable);

    Optional<UserProfile> findByUserAndProfile(User user, Profile profile);

}
