package com.detrasoft.historapp.auth.api.dto.user;

import com.detrasoft.historapp.auth.domain.entities.TypeUser;
import com.detrasoft.historapp.auth.domain.services.validation.PasswordValid;
import com.detrasoft.framework.api.controllers.jackson.ResponseView;
import com.detrasoft.framework.api.dto.AuditDTO;
import com.detrasoft.framework.api.dto.AuditedGenericDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import jakarta.validation.constraints.NotBlank;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements AuditedGenericDTO {

    @JsonIgnore
    protected Long id;

    @JsonView({ResponseView.findById.class, ResponseView.findAll.class})
    private String code;

    @JsonView(ResponseView.findAll.class)
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank @PasswordValid
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private TypeUser type;

    private String phone;

    private Long idDetrasoft;

    @NotBlank
    private String business;

    private String urlImage;

    private String urlHome;

    private AuditDTO audit = new AuditDTO();
}
