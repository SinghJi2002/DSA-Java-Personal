package OOPs.F_Interfaces;
//1.Interfaces:Collection of unimplemented methods.

//11.If in case we have interfaces having ditto methods(name and structure wise), its better that the class that implements these interfaces has its own method that overides these methods. Look at the play method in camera and media player.
interface camera {
    //2.All the methods and datamembers inside a interface are of public nature. Though note that the datamembers are of final nature. That we can access it but we cannot change its value. But its value can be changed if declared public.
    int x=5;
    void photoclick();
    void record();
    void play();
}
//10.Implementing a interface in a class by another class. Look onto smartphone class now.
class location{
    interface gps{
        void currentLocation();
        void locationToGo();
        void route();
        void distance();
    }
}
interface mediaplayer{
    void play();
    void pause();
    void fastforward();
    void next();
    void previous();
    //7. We can use default on the interface method. If done correctly, then we can use this interface without implementing this particular method.
    default void slow(){

    };
}

//8.We can apply inheritance on interfaces.
interface cam extends camera {
    void click();
}

//9. When implementing interfaces, if in case we encounter a situation where we are not implementing one of the interface methods, then we can declare the class abstract and protect ourselves from error.
abstract class error implements mediaplayer{

}
//No errors even when nothing of mediaplayer interface is implemented.

class phone {
    void call(){
        System.out.println("Calling");
    }
    void recive(){
        System.out.println("Recieving");
    }
}
//3.Below we are implementing multi inheritance via implementing multiple interfaces and extending single class.
public class smartphone extends phone implements camera,location.gps,mediaplayer /*gps is implemented differently. Further see how differences arise when we use gps as reference.*/{
    //4.When implementing methods of interfaces, declare them public.
    public void currentLocation(){
        System.out.println("Current location is Baghbera");
    }
    public void locationToGo(){
        System.out.println("Location to go is Bistupur");
    }
    public void route(){
        System.out.println("We take flyover route");
    }
    public void distance(){
        System.out.println("Distance is 2 kms");
    }
    public void photoclick(){
        System.out.println("Chichik");
    }
    public void record(){
        System.out.println("Recording");
    }
    //Overiding method of the implementing class.
    public void play(){
        System.out.println("Playing");
    }
    public void pause(){
        System.out.println("Paused");
    }
    public void fastforward(){
        System.out.println("Playing at 2x");
    }
    public void next(){
        System.out.println("Playing next song");
    }
    public void previous(){
        System.out.println("Playing previous song");
    }
    
    public class Main {
        public static void main(String[] args) {
            //mediaplayer mp=new mediaplayer(); 5.We cannot create objects of interfaces.
            mediaplayer mp=new smartphone();//6.Though we can use interfaces are references for classes.
            smartphone sm=new smartphone();
            //Polymorphism in Java
            location.gps g=new smartphone();
            sm.next();
        }    
    }
}
