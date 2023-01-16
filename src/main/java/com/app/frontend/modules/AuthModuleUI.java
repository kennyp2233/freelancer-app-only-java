package com.app.frontend.modules;

import com.app.backend.auth.controllers.AuthController;
import com.app.frontend.components.auth.AuthComponentUI;
import com.app.frontend.services.AuthServiceUI;

public class AuthModuleUI {
  private AuthComponentUI authComponentUI;
  private AuthServiceUI authServicesUI;

  public AuthModuleUI(AuthController authController) {
    this.authServicesUI = new AuthServiceUI(authController);
    this.authComponentUI = new AuthComponentUI(this.authServicesUI);
  }

  public AuthComponentUI getAuthComponentUI() {
    return this.authComponentUI;
  }

  public AuthServiceUI getAuthServicesUI() {
    return this.authServicesUI;
  }
}
