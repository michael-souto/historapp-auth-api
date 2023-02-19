package com.detrasoft.historapp.auth.domain.services.validation.impl;

import com.detrasoft.historapp.auth.domain.entities.ProfileRole;
import com.detrasoft.historapp.auth.domain.repositories.ProfileRoleRepository;
import com.detrasoft.historapp.auth.domain.services.validation.RoleAlreadyAddedProfileValid;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RoleAlreadyAddedProfileValidator implements ConstraintValidator<RoleAlreadyAddedProfileValid, ProfileRole> {

    @Autowired
    private ProfileRoleRepository profileRoleRepository;

    @Override
    public void initialize(RoleAlreadyAddedProfileValid constraintAnnotation) {}

    @Override
    public boolean isValid(ProfileRole value, ConstraintValidatorContext context) {
        if (profileRoleRepository != null) {
            if (value.getId() == null) {
                var role = profileRoleRepository.findByRoleAndProfile(value.getRole(), value.getProfile());
                return role.isEmpty();
            } else {
                return true;
            }
        }
        return true;
    }
}
