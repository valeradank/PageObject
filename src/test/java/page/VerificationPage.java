package page;

import com.codeborne.selenide.SelenideElement;

import data.DataHelper;
import page.DashboardPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeFiled = $("[data-test-id=code] input");
    private SelenideElement acceptFiled = $("[data-test-id=action-verify]");

    public DashboardPage validCode (DataHelper.VerificationCode info){
        codeFiled.setValue(info.getCode());
        acceptFiled.click();
        return new DashboardPage();
    }
}