public class PayTMAdapter implements PaymentProcessor {
    private PayTM paytm;
    public PayTMAdapter(PayTM paytm) {
        this.paytm=paytm;
    }
    public void processPayment() {
        paytm.makePayment();
    }
}
