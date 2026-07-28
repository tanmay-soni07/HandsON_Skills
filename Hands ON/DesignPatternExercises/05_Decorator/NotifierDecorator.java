abstract class NotifierDecorator implements Notifier{

    protected Notifier notifier;

    NotifierDecorator(Notifier notifier){
        this.notifier=notifier;
    }
}