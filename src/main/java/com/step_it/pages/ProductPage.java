package com.step_it.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage{
    @FindBy(css = ".inventory_item_description")
    private List<WebElement> productDescriptions;

    private final By addRemoveBtn = By.tagName("button");
    private final By productNameEl = By.cssSelector(".inventory_item_name");

    public void waitUntilProductsAreDisplayed() {
        getPageLoader().isListLisible(productDescriptions, 0);
    }


    public void addProductToCart(String targetProductName) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getProduct(targetProductName).findElement(addRemoveBtn).click();
    }

    private WebElement getProduct(String targetProductName) {
        for (WebElement product: productDescriptions) {
            WebElement productNameEl = product.findElement(this.productNameEl);
            if (targetProductName.equalsIgnoreCase(productNameEl.getText()))
                return product;
        }
        throw new NoSuchElementException("Couldn't find element " + targetProductName);
    }
}
