public class PhonePeAdapter implements PaymentProcessor{
    private PhonePe phonepe;
    public PhonePeAdapter(PhonePe phonepe) {
        this.phonepe=phonepe;
    }
    public void processPayment() {
        phonepe.makePayment();
    }
}
