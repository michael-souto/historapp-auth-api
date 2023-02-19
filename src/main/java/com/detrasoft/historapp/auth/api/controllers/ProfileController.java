package com.detrasoft.historapp.auth.api.controllers;

import com.detrasoft.historapp.auth.api.converters.ProfileConverter;
import com.detrasoft.historapp.auth.api.dto.ProfileDTO;
import com.detrasoft.historapp.auth.domain.services.crud.ProfileCRUDService;
import com.detrasoft.framework.api.controllers.GenericCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController extends GenericCRUDController<ProfileDTO> {

    @Autowired
    public ProfileController(ProfileCRUDService service, ProfileConverter converter) {
        super(service, converter);
    }
}

