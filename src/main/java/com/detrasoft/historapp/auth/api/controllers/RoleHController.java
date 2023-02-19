package com.detrasoft.historapp.auth.api.controllers;

import com.detrasoft.historapp.auth.api.converters.RoleAssembler;
import com.detrasoft.historapp.auth.api.dto.RoleDTO;
import com.detrasoft.historapp.auth.domain.services.crud.RoleCRUDService;
import com.detrasoft.framework.api.controllers.hateoas.GenericHateoasCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hateoas/roles")
public class RoleHController extends GenericHateoasCRUDController<RoleDTO> {

    public RoleHController(RoleCRUDService service, RoleAssembler assembler) {
        super(service, assembler);
    }
}
