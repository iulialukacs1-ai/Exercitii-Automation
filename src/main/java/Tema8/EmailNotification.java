package Tema8;

public class EmailNotification extends Notification{
    private String emailAddress;

    //Getter
    public String getEmailAddress() {
        return emailAddress;
    }

    //Setter

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send() {
        System.out.println("Sending email to: " + emailAddress);
    }
}
