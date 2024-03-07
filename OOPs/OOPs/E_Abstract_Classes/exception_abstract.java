//4. If in case a class inherits a abstract class and we want to not implement certain abstract methods of the parent abstract class, we would be required to declare the whole inherited class as abstract itself.
abstract public class exception_abstract extends Parent {
    public void career(){
        System.out.println("I want to be economist");
    }
}
