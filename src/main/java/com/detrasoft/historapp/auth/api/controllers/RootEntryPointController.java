package com.detrasoft.historapp.auth.api.controllers;

import com.detrasoft.historapp.auth.api.controllers.users.UserGetController;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class RootEntryPointController {
    @GetMapping
    public RootEntryPointModel root() {
        var rootEntryPointModel = new RootEntryPointModel();

        rootEntryPointModel.add(linkTo(UserGetController.class).withRel("users"));
        rootEntryPointModel.add(linkTo(ProfileController.class).withRel("profiles"));
        rootEntryPointModel.add(linkTo(RoleController.class).withRel("roles"));

        return rootEntryPointModel;
    }

    private static class RootEntryPointModel extends RepresentationModel<RootEntryPointModel> {
    }

}
