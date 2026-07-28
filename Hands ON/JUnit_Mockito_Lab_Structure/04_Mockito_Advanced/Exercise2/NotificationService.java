public class NotificationService {

    private EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendWelcomeEmail(String name) {

        emailService.sendEmail("Welcome " + name);

    }

}