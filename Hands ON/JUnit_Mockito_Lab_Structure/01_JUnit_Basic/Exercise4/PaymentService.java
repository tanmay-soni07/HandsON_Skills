public class PaymentService {

    private PaymentGateway gateway;

    public PaymentService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void makePayment(double amount) {
        gateway.processPayment(amount);
    }

}