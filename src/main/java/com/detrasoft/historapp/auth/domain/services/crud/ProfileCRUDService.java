package com.detrasoft.historapp.auth.domain.services.crud;

import com.detrasoft.historapp.auth.domain.entities.Profile;
import com.detrasoft.historapp.auth.domain.repositories.ProfileRepository;
import com.detrasoft.framework.crud.services.crud.GenericCRUDService;
import org.springframework.stereotype.Service;

@Service
public class ProfileCRUDService extends GenericCRUDService<Profile> {

    public ProfileCRUDService(ProfileRepository repository) {
        super(repository);
    }

    @Override
    protected void beforeInsert(Profile entity) {
        entity.setIdDetrasoft(1L);
    }

    @Override
    protected void beforeUpdate(Profile entity) {
        entity.setIdDetrasoft(1L);
    }

//    @Override
//    protected ProfileDTO toDto(Profile entity) {
//
//        var profile = ProfileDTO.builder()
//
//                .name(entity.getName())
//                .roles(
//                        entity.getRoles()
//                                .stream()
//                                .map(r -> ProfileRoleDTO
//                                        .builder()
//                                        .id(r.getId())
//                                        .idProfile(entity.getId())
//                                        .role(new RoleDTO(
//                                                r.getRole().getId(),
//                                                r.getRole().getCode(),
//                                                r.getRole().getName()))
//                                        .build()
//                                ).toList()
//                )
//                .build();
//        profile.setId(entity.getId());
//        return profile;
//    }
}
