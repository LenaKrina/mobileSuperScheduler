package com.superscheduler.mobile.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {
    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }


    public void confirmLogin() {
        tap(By.xpath("//*[resource-id='login_btn']"));
    }

    public void fillLoginForm(String userEmail, String password) {
        type(By.xpath("//*[resource-id='log_email_input']"), userEmail);
        type(By.xpath("//*[resource-id='log_password_input']"), password);

    }


}
