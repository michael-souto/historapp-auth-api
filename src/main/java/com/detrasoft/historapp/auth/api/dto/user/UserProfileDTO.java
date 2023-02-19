package com.detrasoft.historapp.auth.api.dto.user;

import com.detrasoft.historapp.auth.api.dto.ProfileDTO;
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
public class UserProfileDTO implements GenericDTO {

    private Long id;

    private Long idUser;

    @Valid
    @ConvertGroup(from = Default.class, to = GroupsIdsValidation.ProfileId.class)
    @NotNull
    private ProfileDTO profile;
}
