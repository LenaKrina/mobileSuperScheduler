package com.superscheduler.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    AppiumDriver driver;
    // BoardHelper board;
    // TeamHelper team;
    SessionHelper session;
    String browser;
    // ProfileHelper profile;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException, IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "192.168.232.102:5555");
        capabilities.setCapability("platformVersion", "8.0");

        capabilities.setCapability("automationName", "Appium");

        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");

        capabilities.setCapability("app", "C:/Users/Elena/Documents/GitHub/mobileSuperScheduler/apk/v.0.0.3.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


        session = new SessionHelper(driver);

    }

    public void stop() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    public SessionHelper getSession() {
        return session;
    }
}
