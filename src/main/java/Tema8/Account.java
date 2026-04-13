package Tema8;

public class Account {
    private String username;

    //Getteri

    public String getusername() {
        return username;
    }

    // Setteri
    public void setusername(String username) {
        this.username = username;
    }

    //metoda login
    public void login() {
        System.out.println(username + " s-a logat!");
    }
}
