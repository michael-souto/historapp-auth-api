package com.detrasoft.historapp.auth.domain.services.validation;

import com.detrasoft.historapp.auth.domain.services.validation.impl.PasswordValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValid {
    String message() default "A senha precisa ter entre 8 a 20 caracteres com letras maiusculas, minusculas numeros e alguns destes caracteres especiais !@#&()–[{}]:;',?/*~$^+=<>";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
