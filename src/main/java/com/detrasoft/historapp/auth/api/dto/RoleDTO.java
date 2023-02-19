package com.detrasoft.historapp.auth.api.dto;

import com.detrasoft.historapp.auth.domain.services.validation.groups.GroupsIdsValidation;
import com.detrasoft.framework.api.dto.GenericRepresentationModelDTO;
import lombok.*;
import org.springframework.hateoas.server.core.Relation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Relation(collectionRelation = "roles")
public class RoleDTO extends GenericRepresentationModelDTO<RoleDTO> {

    @NotNull(groups = GroupsIdsValidation.RoleId.class)
    private Long id;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    public void setId(Long id) { this.id = id; }
}
