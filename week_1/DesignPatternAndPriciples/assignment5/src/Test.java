public class Test {
    public static void main(String[] args) throws Exception {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        smsNotifier.send("First through SMS to all");

        slackNotifier.send("Through Slack to all");
    }
}
