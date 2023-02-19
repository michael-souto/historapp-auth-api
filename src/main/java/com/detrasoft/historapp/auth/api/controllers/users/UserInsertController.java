package com.detrasoft.historapp.auth.api.controllers.users;

import com.detrasoft.historapp.auth.api.converters.user.UserInsertConverter;
import com.detrasoft.historapp.auth.api.dto.user.UserInsertDTO;
import com.detrasoft.historapp.auth.domain.services.crud.user.UserInsertService;
import com.detrasoft.framework.api.controllers.crud.GenericInsertController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserInsertController extends GenericInsertController<UserInsertDTO> {
    @Autowired
    public UserInsertController(UserInsertService service, UserInsertConverter converter) {
        super(service, converter);
    }
}
