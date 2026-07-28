public class NotificationManager {

    private EmailService emailService;

    public NotificationManager(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notifyUser(String message) {

        emailService.sendEmail(message);

    }

}