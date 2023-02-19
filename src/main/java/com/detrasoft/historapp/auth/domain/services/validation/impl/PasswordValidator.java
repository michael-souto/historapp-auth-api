package com.detrasoft.historapp.auth.domain.services.validation.impl;

import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.historapp.auth.domain.services.validation.PasswordValid;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PasswordValid, String> {

    @Autowired
    private UserRepository repository;
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public void initialize(PasswordValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password.length() > 30) {
            return true;
        } else {
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }
    }
}
