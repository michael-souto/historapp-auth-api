package com.detrasoft.historapp.auth.api.dto.user;

import com.detrasoft.historapp.auth.domain.services.validation.UserInsertValid;
import com.detrasoft.framework.api.dto.AuditDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@UserInsertValid
public class UserInsertDTO extends UserDTO {
    @JsonIgnore
    private AuditDTO audit;
}
