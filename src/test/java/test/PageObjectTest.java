package test;

import data.DataHelper;


import org.junit.jupiter.api.Test;

import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PageObjectTest {


    @Test
    void pageObjectTest() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.validCode(verificationCode);
        var firstCardBalance = DataHelper.getFirstCardBalance();
        var secondCardBalance = DataHelper.getSecondCardBalance();
        var firstCardInfo = dashboardPage.getCardBalance(firstCardBalance);
        var secondCardInfo = dashboardPage.getCardBalance(secondCardBalance);
        var amount = DataHelper.generateValidAmount(firstCardInfo);
        var expectedBalanceOfFirstCard = firstCardInfo - amount;
        var expectedBalanceOfSecondCard = secondCardInfo + amount;
        var transferPage = dashboardPage.selectCardToTransfer(secondCardBalance);
        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), firstCardBalance);
        var actualBalanceOfFirstCard = dashboardPage.getCardBalance(firstCardBalance);
        var actualBalanceOfSecondCard = dashboardPage.getCardBalance(secondCardBalance);
        assertEquals(expectedBalanceOfFirstCard, actualBalanceOfFirstCard);
        assertEquals(expectedBalanceOfSecondCard, actualBalanceOfSecondCard);

    }


}
