package com.detrasoft.historapp.auth.api.converters;

import com.detrasoft.historapp.auth.api.dto.ProfileRoleDTO;
import com.detrasoft.historapp.auth.api.dto.RoleDTO;
import com.detrasoft.historapp.auth.domain.entities.ProfileRole;
import com.detrasoft.historapp.auth.domain.repositories.ProfileRepository;
import com.detrasoft.historapp.auth.domain.repositories.RoleRepository;
import com.detrasoft.framework.api.dto.converters.GenericEntityDTOConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileRoleConverter extends GenericEntityDTOConverter<ProfileRole, ProfileRoleDTO> {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    protected void copyDtoToEntity(ProfileRoleDTO dto, ProfileRole entity) {
        entity.setRole(roleRepository.getReferenceById(dto.getRole().getId()));
        entity.setProfile(profileRepository.getReferenceById(dto.getIdProfile()));
        super.copyDtoToEntity(dto,entity);
    }

    @Override
    protected void copyEntityToDto(Object obj, ProfileRoleDTO dto) {
        dto.setId(((ProfileRole)obj).getId());
        dto.setIdProfile(((ProfileRole)obj).getProfile().getId());
        dto.setRole(new RoleDTO());
        BeanUtils.copyProperties(((ProfileRole)obj).getRole(), dto.getRole());
    }
}
