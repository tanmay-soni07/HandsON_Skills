class SMSNotifierDecorator extends NotifierDecorator{

    SMSNotifierDecorator(Notifier n){
        super(n);
    }

    public void send(){
        notifier.send();
        System.out.println("SMS Sent");
    }
}