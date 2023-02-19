package com.detrasoft.historapp.auth.api.controllers.users;

import com.detrasoft.historapp.auth.api.converters.user.UserUpdateConverter;
import com.detrasoft.historapp.auth.api.dto.user.UserUpdateDTO;
import com.detrasoft.historapp.auth.domain.services.crud.user.UserUpdateService;
import com.detrasoft.framework.api.controllers.crud.GenericUpdateController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserUpdateController extends GenericUpdateController<UserUpdateDTO> {
    @Autowired
    public UserUpdateController(UserUpdateService service, UserUpdateConverter converter) {
        super(service, converter);
    }
}
