package com.detrasoft.historapp.auth.api.dto;

import com.detrasoft.historapp.auth.domain.services.validation.groups.GroupsIdsValidation;
import com.detrasoft.framework.api.dto.GenericDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileDTO implements GenericDTO {

    @NotNull(groups = GroupsIdsValidation.ProfileId.class)
    private Long id;

    @NotNull
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idDetrasoft;

    private List<ProfileRoleDTO> roles;

    public void setId(Long id) {
        this.id = id;
    }

}
