package com.detrasoft.historapp.auth.api.converters.user;

import com.detrasoft.historapp.auth.api.dto.user.UserInsertDTO;
import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.framework.api.dto.converters.GenericEntityDTOConverter;
import org.springframework.stereotype.Component;

@Component
public class UserInsertConverter extends GenericEntityDTOConverter<User, UserInsertDTO> {
}
