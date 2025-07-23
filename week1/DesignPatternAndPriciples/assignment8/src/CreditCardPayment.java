public class CreditCardPayment implements PaymentStrategy{
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardHolderName, String cardNumber, String cvv, String expiryDate) {
        this.cardHolderName=cardHolderName;
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiryDate=expiryDate;
    }

    public void pay(double amount) {
        System.out.println("Payment via Credit Card of amount: " + amount);
    }
}
