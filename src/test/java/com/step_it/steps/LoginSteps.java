package com.step_it.steps;

import com.step_it.pages.LoginPage;
import com.step_it.pages.MainPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class LoginSteps {

    private final LoginPage loginPage;
    private final MainPage mainPage;

    public void login(String username, String password) {
        log.info("User logs in with username & password");
        loginPage.login(username, password);
    }

    public void logout() {
        log.info("User logs out from the app");
        mainPage.logout();
    }
}
