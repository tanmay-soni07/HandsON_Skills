
public class Main {
    public static void main(String[] args) {
public class Main{

    public static void main(String[] args){

        Notifier n = new SMSNotifierDecorator(new EmailNotifier());

        n.send();
    }
}    }
}
