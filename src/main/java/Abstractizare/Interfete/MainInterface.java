package Abstractizare.Interfete;

public class MainInterface {
    public static void main(String[]args) {
        LoginPage loginpage = new LoginPage();
        loginpage.enterUsername("iulia");
        loginpage.enterPassword("Tzuki");
        loginpage.clickLogin();
    }
}
