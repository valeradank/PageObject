package page;

import com.codeborne.selenide.SelenideElement;

import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement sumFiled = $("[data-test-id= amount] input");
    private SelenideElement numCardFiled = $("[data-test-id= from] input");
    private SelenideElement transFiled = $("[data-test-id=action-transfer]");
    private SelenideElement transCancel = $("[data-test-id=action-cancel]");
    private SelenideElement errorMessage = $("[data-test-id='error-message']");


    public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        sumFiled.setValue(amountToTransfer);
        numCardFiled.setValue(cardInfo.getCardNumber());
        transFiled.click();
    }

    public void noMakeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        sumFiled.setValue(amountToTransfer);
        numCardFiled.setValue(cardInfo.getCardNumber());
        transCancel.click();
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

    public void findErrorMassage(String expectedText) {
        errorMessage.shouldHave(exactText(expectedText), Duration.ofSeconds(15)).shouldBe(visible);
    }
}

