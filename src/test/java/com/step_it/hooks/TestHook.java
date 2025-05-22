package com.step_it.hooks;

import com.step_it.utils.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.step_it.driver.CustomWebDriverManager.*;

@Slf4j
public class TestHook {

    @Before(value = "@Start")
    public void startBrowser() {
        log.info("Opening the application login page");
        startDriver();
        getDriver().get(PropertyReader.getConfigProperty("url"));
    }

    @Before
    public void beforeScenario(Scenario scenario){
        log.info("Starting scenario: {}", scenario.getName());
        log.info("Scenario tag: {}", scenario.getSourceTagNames());
    }

    @AfterStep
    public void addScreenshot(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image" + scenario.getName());
        }
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario){
        log.info("Finished scenario: {}", scenario.getName());
    }


    @After(value = "@Stop")
    public void driverTearDown() {
        log.info("Quitting the driver");
        quitDriver();
    }
}
