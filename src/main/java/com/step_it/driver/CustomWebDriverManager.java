package com.step_it.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CustomWebDriverManager {
    private static WebDriver driver;

    public static void startDriver() {
        WebDriverManager.chromedriver().setup();
        EdgeOptions options = new EdgeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("improved_password_change_service", false);
//        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("prefs", prefs);
        driver = new EdgeDriver();

        new WebDriverWait(driver, Duration.ofSeconds(5));
        Listener listener = new Listener();
        EventFiringDecorator<WebDriver> decorator =
                new EventFiringDecorator<>(listener);
        driver = decorator.decorate(driver);
    }

    public static void quitDriver(){
        getDriver().quit();
    }

    public static WebDriver getDriver() {
        if (driver == null) startDriver();
        return driver;
    }
}
