package Tema8;

public class LoginService {
    public void login(User user) {
        System.out.println("Logging in with username: " + user.getUsername());
        System.out.println("Logging in with password: " + user.getPassword());
    }
}
