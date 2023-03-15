package page;

import com.codeborne.selenide.SelenideElement;

import data.DataHelper;


import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    private SelenideElement loginFiled = $("[data-test-id=login] input");
    private SelenideElement passwordFiled = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginFiled.setValue(info.getLogin());
        passwordFiled.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

}
