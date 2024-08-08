package DecoratorPatternExample;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier emailAndSMSNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier emailSMSAndSlackNotifier = new SlackNotifierDecorator(emailAndSMSNotifier);

        System.out.println("Sending email only:");
        emailNotifier.send("Hello, this is an email!");

        System.out.println("\nSending email and SMS:");
        emailAndSMSNotifier.send("Hello, this is an email and SMS!");

        System.out.println("\nSending email, SMS, and Slack:");
        emailSMSAndSlackNotifier.send("Hello, this is an email, SMS, and Slack!");
    }
}
