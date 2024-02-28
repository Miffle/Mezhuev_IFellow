package ru.iFellow;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement usernameInput = $x("//input[@id='login-form-username']");
    private final SelenideElement passwordInput = $x("//input[@id='login-form-password']");
    private final SelenideElement loginButton = $x("//input[@id='login']");
    private final SelenideElement errorMessage = $x("//div[@id='usernameerror']");
    private final SelenideElement headerLoginButton = $x("//div[@id='usernameerror']");

    public void insertUsername(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
    public boolean checkHeaderLoginButtonExistence(){
        return headerLoginButton.shouldNot(exist).exists();
    }
}