package com.detrasoft.historapp.auth.api.controllers;

import com.detrasoft.historapp.auth.api.converters.RoleConverter;
import com.detrasoft.historapp.auth.api.dto.RoleDTO;
import com.detrasoft.historapp.auth.domain.services.crud.RoleCRUDService;
import com.detrasoft.framework.api.controllers.GenericCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roles")
public class RoleController extends GenericCRUDController<RoleDTO> {

    @Autowired
    public RoleController(RoleCRUDService service, RoleConverter converter) {
        super(service, converter);
    }
}
