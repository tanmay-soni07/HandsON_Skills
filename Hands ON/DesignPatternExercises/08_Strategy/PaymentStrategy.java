interface PaymentStrategy{
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy{

    public void pay(int amount){
        System.out.println("Paid by Credit Card "+amount);
    }
}

class PayPalPayment implements PaymentStrategy{

    public void pay(int amount){
        System.out.println("Paid by PayPal "+amount);
    }
}

class PaymentContext{

    PaymentStrategy strategy;

    PaymentContext(PaymentStrategy s){
        strategy=s;
    }

    void execute(int amount){
        strategy.pay(amount);
    }
}