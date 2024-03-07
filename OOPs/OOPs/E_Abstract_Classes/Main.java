

public class Main {
    public static void main(String[] args) {
        //Parent p1=new Parent();
        //8. Abstract class cannot have object.
        //9. We can can although call the methods of abs class via the class name itself.
        Parent.print();
        //10.We although implement polymorphism via attaching a subclass object to parent class reference.
        Parent p1=new Son();
    }
    
}
