package com.step_it.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;

@Slf4j
public class Listener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        log.info("Clicking on {}",
                getElement(element));
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence[] keyToSend) {
        log.info("Changing value " + Arrays.toString(keyToSend) +
                " for ", getElement(element));
        System.out.println("Changing value " + Arrays.toString(keyToSend) +
                " for " + getElement(element));
    }

    private String getElement(WebElement element) {
        String text = element.getText();
        if (!text.isEmpty()) {
            return text;
        }
        if (!element.getDomAttribute("id").isEmpty()) {
            return element.getDomAttribute("id");
        }
        if (!element.getDomAttribute("class").isEmpty()) {
            return element.getDomAttribute("class");
        }
        return "";
    }
}
