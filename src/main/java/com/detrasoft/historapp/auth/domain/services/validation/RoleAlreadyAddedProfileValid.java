package com.detrasoft.historapp.auth.domain.services.validation;

import com.detrasoft.historapp.auth.domain.services.validation.impl.RoleAlreadyAddedProfileValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RoleAlreadyAddedProfileValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RoleAlreadyAddedProfileValid {
    String message() default "{RoleAlreadyAddedProfileValidator}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
