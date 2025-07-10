public class SlackNotifierDecorator extends NotifierDecorator{ 
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String msg) {
        super.send(msg);
        slackNotifier(msg);
    }

    private void slackNotifier(String msg) {
        System.out.println("Slack Notifier: " + msg);
    }
}
