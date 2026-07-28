interface Image{
    void display();
}

class RealImage implements Image{

    String file;

    RealImage(String file){
        this.file=file;
        System.out.println("Loading "+file);
    }

    public void display(){
        System.out.println("Displaying "+file);
    }
}

class ProxyImage implements Image{

    private RealImage image;
    private String file;

    ProxyImage(String file){
        this.file=file;
    }

    public void display(){

        if(image==null)
            image=new RealImage(file);

        image.display();
    }
}

public class Main{

    public static void main(String[] args){

        Image img=new ProxyImage("photo.jpg");

        img.display();
        img.display();
    }
}