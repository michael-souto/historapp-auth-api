package com.detrasoft.historapp.auth.api.converters.user;

import com.detrasoft.historapp.auth.api.dto.user.UserUpdateDTO;
import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.framework.api.dto.converters.GenericEntityDTOConverter;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateConverter extends GenericEntityDTOConverter<User, UserUpdateDTO> {
}
