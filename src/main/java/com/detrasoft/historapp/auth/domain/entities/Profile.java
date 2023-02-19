package com.detrasoft.historapp.auth.domain.entities;

import com.detrasoft.framework.security.domain.entities.AuditedGenericEntity;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile_pl")
public class Profile extends AuditedGenericEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull @Positive
    private Long idDetrasoft;

    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER) @Setter(AccessLevel.NONE)
    private List<ProfileRole> roles = new ArrayList<>();
}
