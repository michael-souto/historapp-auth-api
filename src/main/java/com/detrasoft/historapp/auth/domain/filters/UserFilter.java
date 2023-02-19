package com.detrasoft.historapp.auth.domain.filters;

import com.detrasoft.historapp.auth.domain.entities.TypeUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.Instant;

@Getter
@Setter
public class UserFilter {
    private String name;
    private String email;
    private TypeUser type;
    private Long idDetrasoft;
    private String business;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Instant initCreateAt;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Instant finalCreateAt;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Instant initUpdatedAt;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Instant finalUpdatedAt;
}
