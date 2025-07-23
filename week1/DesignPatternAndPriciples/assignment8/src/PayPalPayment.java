public class PayPalPayment implements PaymentStrategy{
    private String username;
    private String pass;

    public PayPalPayment(String username, String pass) {
        this.username=username;
        this.pass=pass;
    }

    public void pay(double amount) {
        System.out.println("Payment via PayPal of amount: " + amount);
    }
}
