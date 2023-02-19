package com.detrasoft.historapp.auth.domain.services.validation.impl;

import com.detrasoft.historapp.auth.api.dto.user.UserUpdateDTO;
import com.detrasoft.historapp.auth.domain.repositories.UserRepository;
import com.detrasoft.historapp.auth.domain.services.validation.UserUpdateValid;
import com.detrasoft.framework.api.controllers.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserUpdateValid ann) {
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

        @SuppressWarnings("unchecked")
        var uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        long userId = Long.parseLong(uriVars.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        var user = repository.findByEmail(dto.getEmail());
        if (user.isPresent() && userId != user.get().getId()) {
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