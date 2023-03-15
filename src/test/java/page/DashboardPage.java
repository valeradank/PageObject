package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import data.DataHelper;
import lombok.val;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public int getCardBalance(DataHelper.CardInfo cardInfo) {
        var text = cards.findBy(Condition.text(cardInfo.getCardNumber().substring(12, 16))).getText();
        return takeOffBalance(text);
    }

    private int takeOffBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage selectCardToTransfer(DataHelper.CardInfo cardInfo) {
        cards.findBy(attribute("data-test-id", cardInfo.getId())).$("button").click();
        return new TransferPage();
    }
}
