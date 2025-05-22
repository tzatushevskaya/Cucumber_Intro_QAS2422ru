package com.step_it.step_definitions;

import com.step_it.steps.CommonSteps;
import com.step_it.steps.ProductSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDefinitions {
    private ProductSteps productSteps;
    private CommonSteps commonSteps;

    @Given("the app is on product page")
    public void theAppIsOnProductPage() {
        productSteps.checkProductsOnPageAreDisplayed();
        
    }

    @When("the user adds {string} to cart")
    public void theUserAddsToCart(String productName) {
        commonSteps.checkCartIsEmpty();
        productSteps.addProductToCart(productName);
    }
}
