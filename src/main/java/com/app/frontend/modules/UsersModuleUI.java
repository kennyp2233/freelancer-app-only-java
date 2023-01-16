package com.app.frontend.modules;

import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.components.profile.ProfileComponentUI;
import com.app.frontend.components.users.UsersComponentUI;
import com.app.frontend.services.UsersServiceUI;

public class UsersModuleUI {
    UsersServiceUI usersServicesUI;
    UsersComponentUI usersComponentUI;
    ProfileComponentUI profileComponentUI;

    public UsersModuleUI(UsersController usersController) {
        this.usersServicesUI = new UsersServiceUI(usersController);
    }

    public void initUsersComponentUI(UserEntity user) {
        this.profileComponentUI = new ProfileComponentUI(user, this.usersServicesUI);
    }

    public ProfileComponentUI getProfileComponentUI() {
        if (this.profileComponentUI == null) {
            throw new RuntimeException("ProfileComponentUI not initialized");
        }
        return this.profileComponentUI;
    }

    public UsersComponentUI getUsersComponentUI() {
        return this.usersComponentUI;
    }

    public UsersServiceUI getUsersServicesUI() {
        return this.usersServicesUI;
    }
}
