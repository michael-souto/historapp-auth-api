package com.detrasoft.historapp.auth.domain.entities;

import com.detrasoft.framework.security.domain.entities.AuditedGenericEntity;
import com.detrasoft.historapp.auth.domain.services.validation.PasswordValid;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_us")
public class  User extends AuditedGenericEntity implements Serializable, UserDetails {

    @Serial
    private static final long serialVersionUID = 4118631919518508186L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 36, updatable = false)
    private String code;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @PasswordValid
    private String password;

    @Enumerated(EnumType.STRING)
    private TypeUser type;

    private String phone;

    @NotNull @Positive
    private Long idDetrasoft;

    @NotBlank
    private String business;

    private String urlImage;

    private String urlHome;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserProfile> profiles = new ArrayList<UserProfile>();

    @Override
    public List<? extends GrantedAuthority> getAuthorities() {
        var result = new ArrayList<SimpleGrantedAuthority>();
        if (!type.equals(TypeUser.Admin)) {
            profiles.forEach(prof -> {
                result.addAll(prof.getProfile().getRoles().stream().map(
                        r -> new SimpleGrantedAuthority(r.getRole().getCode())).toList());
            });
        } else {
            result.add(new SimpleGrantedAuthority("ADMIN"));
        }
        return result;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    @PrePersist
    public void prePersist() {
        super.prePersist();
        code = UUID.randomUUID().toString();
    }
}
