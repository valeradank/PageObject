package data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {}
    public static VerificationCode getVerificationCode() {
        return  new VerificationCode("12345");
    }
    public static AuthInfo getAuthinfo() {
        return new AuthInfo("vasya","qwerty123");
    }
    public static CardInfo getFirstCardInfo(){
        return new  CardInfo("5559 0000 0000 0001","92df3f1c-a033-48e6-8390206f6b1f56c0");
    }
    public static CardInfo getSecondCardInfo(){
        return new CardInfo("5559 0000 0000 0002","0f3f5c2f-249e-4c3d-8287-09f7f039391d");
    }
    public static int generateValidAmount(int balance) {
        return new Random().nextInt(balance) + 1;
    }
    public static int generateInvalidAmount(int balance){
        return Math.abs(balance) + new Random().nextInt(1000);
    }
    @Value
    public static class VerificationCode{
        String code;
    }
    @Value
    public static class CardInfo{
        String cardNumber;
        String testId;
    }
    @Value
    public static class AuthInfo{
        String login;
        String password;
    }
}
