public class Test {
    public static void main(String[] args) throws Exception {
        GPay gpay = new GPay();
        PayTM paytm = new PayTM();
        PhonePe phonepe = new PhonePe();

        PaymentProcessor gpayAdapter = new GPayAdapter(gpay);
        PaymentProcessor paytmAdapter = new PayTMAdapter(paytm);
        PaymentProcessor phonepeAdapter = new PhonePeAdapter(phonepe);

        gpayAdapter.processPayment();
        paytmAdapter.processPayment();
        phonepeAdapter.processPayment();
    }
}
