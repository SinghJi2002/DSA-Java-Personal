//3.Abstract class are there to be inherited and the abstract methods must be implemented by the class that inherit the abstract, even if one abstract method is left out, we find ourselves in error.
public class Son extends Parent{
    public void career(){
        System.out.println("I want to be an engineer");
    }
    public void love(){
        System.out.println("I love maitry");
    }
}
