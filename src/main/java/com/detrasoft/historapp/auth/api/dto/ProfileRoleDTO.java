package com.detrasoft.historapp.auth.api.dto;

import com.detrasoft.historapp.auth.domain.services.validation.groups.GroupsIdsValidation;
import com.detrasoft.framework.api.dto.GenericDTO;
import lombok.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileRoleDTO implements GenericDTO {

    private Long id;

    private Long idProfile;

    @NotNull @Valid
    @ConvertGroup(from = Default.class, to = GroupsIdsValidation.RoleId.class)
    private RoleDTO role;
}
