package com.detrasoft.historapp.auth.domain.services.validation.impl;

import com.detrasoft.historapp.auth.api.dto.user.UserDTO;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.historapp.auth.domain.services.validation.UserInsertValid;
import com.detrasoft.framework.api.controllers.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserDTO> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(UserDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        var user = repository.findByEmail(dto.getEmail());
        if (user.isPresent()) {
            list.add(new FieldMessage("email", "Email já existe"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }

}