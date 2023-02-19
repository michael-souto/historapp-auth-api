package com.detrasoft.historapp.auth.domain.entities;

import com.detrasoft.framework.security.domain.entities.AuditedGenericEntity;
import com.detrasoft.historapp.auth.domain.services.validation.RoleAlreadyAddedProfileValid;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@RoleAlreadyAddedProfileValid
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile_role_pr")
public class ProfileRole extends AuditedGenericEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @NotNull
    @JoinColumn(name = "profile_id", nullable = false, foreignKey = @ForeignKey(name = "fk1_profile_role_pr"))
    private Profile profile;

    @ManyToOne @NotNull
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "fk2_profile_role_pr"))
    private Role role;
}
