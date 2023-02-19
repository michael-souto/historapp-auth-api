package com.detrasoft.historapp.auth.domain.entities;

import com.detrasoft.framework.security.domain.entities.AuditedGenericEntity;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_rl")
public class Role extends AuditedGenericEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String code;

    @NotBlank
    @Size(min = 4, max = 30)
    private String name;
}
