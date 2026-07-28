import java.util.*;

class StockMarket implements Stock{

    List<Observer> list=new ArrayList<>();
    float price;

    public void register(Observer o){
        list.add(o);
    }

    public void notifyObservers(){

        for(Observer o:list)
            o.update(price);
    }

    void setPrice(float p){
        price=p;
        notifyObservers();
    }
}