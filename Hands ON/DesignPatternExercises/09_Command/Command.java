interface Command{
    void execute();
}

class Light{

    void on(){
        System.out.println("Light ON");
    }

    void off(){
        System.out.println("Light OFF");
    }
}

class LightOnCommand implements Command{

    Light light;

    LightOnCommand(Light l){
        light=l;
    }

    public void execute(){
        light.on();
    }
}

class RemoteControl{

    Command command;

    void setCommand(Command c){
        command=c;
    }

    void press(){
        command.execute();
    }
}