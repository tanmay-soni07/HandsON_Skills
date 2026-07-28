// Main.java
// Paste the implementation for 08_Strategy here.
public class Main {
    public static void main(String[] args) {
public class Main{

    public static void main(String[] args){

        PaymentContext p=new PaymentContext(new CreditCardPayment());

        p.execute(1000);
    }
}    }
}
