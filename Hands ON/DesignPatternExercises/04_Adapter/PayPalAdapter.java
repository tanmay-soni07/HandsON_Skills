class PayPalAdapter implements PaymentProcessor {

    private PayPal paypal = new PayPal();

    public void processPayment(int amount){
        paypal.pay(amount);
    }
}