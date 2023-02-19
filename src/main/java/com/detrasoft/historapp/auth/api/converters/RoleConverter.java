package com.detrasoft.historapp.auth.api.converters;

import com.detrasoft.historapp.auth.api.dto.RoleDTO;
import com.detrasoft.historapp.auth.domain.entities.Role;
import com.detrasoft.framework.api.dto.converters.GenericEntityDTOConverter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter extends GenericEntityDTOConverter<Role, RoleDTO> {
}
