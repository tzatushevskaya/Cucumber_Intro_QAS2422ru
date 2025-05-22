package com.step_it.steps;

import com.step_it.pages.LoginPage;
import com.step_it.pages.MainPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@AllArgsConstructor
public class CommonSteps {
    private final LoginPage loginPage;
    private final MainPage mainPage;

    public void checkLoginPageIsOpen() {
        log.info("Check login page is open");
        assertThat(loginPage.isLogoDisplayed()).as("The login page is not displayed");
    }

    public void checkUserLoggedIn() {
        log.info("Check user is logged in");
        assertThat(mainPage.isTitleDisplayed()).as("The title is not displayed");
    }

    public void checkCartIsEmpty() {
        log.info("Check cart is empty");
        checkCartCounter(0, "The cart is not empty");
    }

    private void checkCartCounter(int counter, String assertionMessage) {
        assertThat(mainPage.getProductCountInCart()).as(assertionMessage).isEqualTo(counter);
    }

    public void checkCartCounterIsUpdatedBy(int amount) {
        log.info("Check cart counter got updated by " + amount);
        checkCartCounter(amount, "The cart counter is not updated");
    }
}
