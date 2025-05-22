package com.step_it.steps;

import com.step_it.pages.ProductPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ProductSteps {
    private final ProductPage productPage;

    public void checkProductsOnPageAreDisplayed() {
        log.info("Check products are displayed");
        productPage.waitUntilProductsAreDisplayed();
    }

    public void addProductToCart(String productName) {
        log.info("Check user is able to add " + productName + " to cart");
        productPage.addProductToCart(productName);
    }
}
