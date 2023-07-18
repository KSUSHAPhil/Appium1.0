package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestAppium {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "sample_2.2");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void setEmptyStrings() {
        MobileElement el7 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el7.click();
        el7.clear();
        el7.sendKeys("Test String");
        MobileElement el8 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el9.click();
        el9.clear();
        el9.sendKeys("");
        MobileElement el10 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el10.click();
        el10.click();
        MobileElement el11 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
        el11.isDisplayed();
        Assertions.assertEquals("Test String",el11.getText() );

        MobileElement el12 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el12.click();
        el12.clear();
        el12.sendKeys("     ");
        MobileElement el13 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el13.click();
        MobileElement el14 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
        el14.isDisplayed();
        Assertions.assertEquals("Test String",el14.getText() );
    }

    @Test
    public void setNewActivityString () throws InterruptedException {
        MobileElement el15 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el15.click();
        el15.clear();
        el15.sendKeys("New String");
        MobileElement el16 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el16.click();
        Thread.sleep(3000);
        MobileElement el17 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/text");
        el17.isDisplayed();
        Assertions.assertEquals("New String",el17.getText() );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
