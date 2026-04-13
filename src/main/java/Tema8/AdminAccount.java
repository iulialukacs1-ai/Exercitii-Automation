package Tema8;

public class AdminAccount extends Account{
    public void deleteUser (String userToDelete) {
        System.out.println("Admin " + getusername() + " a sters userul: " + userToDelete);
    }
}
