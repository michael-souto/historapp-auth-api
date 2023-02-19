package com.detrasoft.historapp.auth.api.converters;

import com.detrasoft.historapp.auth.api.controllers.RoleHController;
import com.detrasoft.historapp.auth.api.dto.RoleDTO;
import com.detrasoft.historapp.auth.domain.entities.Role;
import com.detrasoft.framework.api.dto.converters.GenericRepresentationModelDTOAssembler;
import org.springframework.stereotype.Component;

@Component
public class RoleAssembler extends GenericRepresentationModelDTOAssembler<Role, RoleDTO> {

    public RoleAssembler() {
        super(RoleHController.class, RoleDTO.class);
    }
}
