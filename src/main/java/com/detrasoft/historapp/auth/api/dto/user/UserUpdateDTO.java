package com.detrasoft.historapp.auth.api.dto.user;

import com.detrasoft.historapp.auth.domain.services.validation.UserUpdateValid;
import com.detrasoft.framework.api.dto.AuditDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO {

    @JsonIgnore
    private AuditDTO audit;
}
