package com.detrasoft.historapp.auth.api.converters;

import com.detrasoft.historapp.auth.api.dto.ProfileDTO;
import com.detrasoft.historapp.auth.api.dto.user.UserProfileDTO;
import com.detrasoft.historapp.auth.domain.entities.UserProfile;
import com.detrasoft.historapp.auth.domain.repositories.ProfileRepository;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.framework.api.dto.converters.GenericEntityDTOConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileConverter extends GenericEntityDTOConverter<UserProfile, UserProfileDTO> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    protected void copyDtoToEntity(UserProfileDTO dto, UserProfile entity) {
        entity.setUser(userRepository.getReferenceById(dto.getIdUser()));
        entity.setProfile(profileRepository.getReferenceById(dto.getProfile().getId()));
        super.copyDtoToEntity(dto,entity);
    }

    @Override
    protected void copyEntityToDto(Object obj, UserProfileDTO dto) {
        dto.setId(((UserProfile)obj).getId());
        dto.setIdUser(((UserProfile)obj).getUser().getId());
        dto.setProfile(new ProfileDTO());
        BeanUtils.copyProperties(((UserProfile)obj).getProfile(), dto.getProfile());
    }
}
