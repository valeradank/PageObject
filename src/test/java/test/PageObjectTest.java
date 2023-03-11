package test;
import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import page.VerificationPage;

import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PageObjectTest {
    LoginPage loginPage;
    @BeforeEach
    void setup() {
        loginPage = open("http://localhost:9999/", LoginPage.class);
    }
    @Test
    void shouldTransferMoneyOnFirstCardToSecond(){
var authInfo = DataHelper.getAuthinfo();
var verificationPage = loginPage.validLogin(authInfo);
var verificationCode = DataHelper.getVerificationCode();
var dashBoardPage = verificationPage.validVerify(verificationCode);
var firstCardInfo = getFirstCardInfo();
var secondCardInfo = getSecondCardInfo();
var firstCardBalance = dashBoardPage.getCardBalance(firstCardInfo);
var secondCardBalance = dashBoardPage.getCardBalance(secondCardInfo);
var amount = generateValidAmount(firstCardBalance);
var expectedBalanceFirstCard = firstCardBalance - amount;
var expectedBalanceSecondCard = secondCardBalance + amount;
var transferPage = dashBoardPage.selectCardToTransfer(secondCardInfo);
var actualBalanceFirstCard = dashBoardPage.getCardBalance(firstCardInfo);
var actualBalanceSecondCard = dashBoardPage.getCardBalance(secondCardInfo);
assertEquals(expectedBalanceFirstCard,actualBalanceFirstCard);
assertEquals(expectedBalanceSecondCard,actualBalanceSecondCard);

    }
}
