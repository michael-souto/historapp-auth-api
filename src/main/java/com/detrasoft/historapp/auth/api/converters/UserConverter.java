package com.detrasoft.historapp.auth.api.converters;

import com.detrasoft.historapp.auth.api.dto.user.UserDTO;
import com.detrasoft.historapp.auth.domain.entities.User;
import com.detrasoft.framework.api.dto.converters.GenericEntityDTOConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends GenericEntityDTOConverter<User, UserDTO> {
    @Override
    protected void copyEntityToDto(Object obj, UserDTO dto) {
        super.copyEntityToDto(obj, dto);
        BeanUtils.copyProperties(((User)obj).getAudit(), dto.getAudit());
    }
}
