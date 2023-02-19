package com.detrasoft.historapp.auth.api.controllers;

import com.detrasoft.historapp.auth.api.converters.ProfileRoleConverter;
import com.detrasoft.historapp.auth.api.dto.ProfileRoleDTO;
import com.detrasoft.historapp.auth.domain.services.crud.ProfileRoleCRUDService;
import com.detrasoft.framework.api.controllers.GenericDetailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "profiles/{idDetail}/roles")
public class ProfileRoleController extends GenericDetailController<ProfileRoleDTO> {

    @Autowired
    public ProfileRoleController(ProfileRoleCRUDService service, ProfileRoleConverter converter) {
        super(service, converter);
    }

    @Override
    protected void setIdSubDetailInDTO(Long idDetail, Long idSubDetail, ProfileRoleDTO dto) {
        dto.setIdProfile(idDetail);
    }
}
