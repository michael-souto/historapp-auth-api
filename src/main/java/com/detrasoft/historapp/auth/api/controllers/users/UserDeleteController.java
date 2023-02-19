package com.detrasoft.historapp.auth.api.controllers.users;

import com.detrasoft.historapp.auth.api.dto.user.UserDTO;
import com.detrasoft.historapp.auth.domain.services.crud.user.UserCRUDService;
import com.detrasoft.framework.api.controllers.crud.GenericDeleteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserDeleteController extends GenericDeleteController<UserDTO> {
    @Autowired
    public UserDeleteController(UserCRUDService service) {
        super(service);
    }
}
