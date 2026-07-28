interface Observer{
    void update(float price);
}

interface Stock{
    void register(Observer o);
    void notifyObservers();
}