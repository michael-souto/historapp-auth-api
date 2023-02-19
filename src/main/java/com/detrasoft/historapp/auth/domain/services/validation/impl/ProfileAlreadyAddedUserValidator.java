package com.detrasoft.historapp.auth.domain.services.validation.impl;

import com.detrasoft.historapp.auth.domain.entities.UserProfile;
import com.detrasoft.historapp.auth.domain.repositories.UserProfileRepository;
import com.detrasoft.historapp.auth.domain.services.validation.ProfileAlreadyAddedUserValid;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProfileAlreadyAddedUserValidator  implements ConstraintValidator<ProfileAlreadyAddedUserValid, UserProfile> {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void initialize(ProfileAlreadyAddedUserValid constraintAnnotation) {}

    @Override
    public boolean isValid(UserProfile value, ConstraintValidatorContext context) {
        if (userProfileRepository != null) {
            if (value.getId() == null) {
                var user = userProfileRepository.findByUserAndProfile(value.getUser(), value.getProfile());
                return user.isEmpty();
            } else {
                return true;
            }
        }
        return true;
    }
}
