package com.detrasoft.historapp.auth.domain.entities;

import com.detrasoft.framework.security.domain.entities.AuditedGenericEntity;
import com.detrasoft.historapp.auth.domain.services.validation.ProfileAlreadyAddedUserValid;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@ProfileAlreadyAddedUserValid
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_profile_up")
public class UserProfile extends AuditedGenericEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk1_user_profile_up"))
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", nullable = false, foreignKey = @ForeignKey(name = "fk2_user_profile_up"))
    private Profile profile;
}
