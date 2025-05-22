package com.step_it.step_definitions;

import com.step_it.steps.LoginSteps;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginDefinitions {

    private final LoginSteps loginSteps;

    @When("the user enters correct {string} and {string}")
    public void theUserEntersCorrectUsernameAndPassword(String username, String password) {
        loginSteps.login(username, password);
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        loginSteps.logout();
    }
}
