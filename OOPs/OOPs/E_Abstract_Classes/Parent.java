//2.If there is even a single abstract method in a class we need to declare the whole class as abstract.
/*final*/ abstract public class Parent {
    //1. We add the abstract keyword whenever we want to create a abstract method.
    abstract public void career();
    abstract public void love();

    //5. We can have constructor build for abstract class. Also note that the constructor cannot be abstract, else error will be generated. Although its important to note that there is no point in creating the constructors of abstracting classes since we cannot create an object of an abstract class.

    public Parent(){
        System.out.println("Hi");
    }

    //abstract public Parent(){}; Error will be seen here

    //6.Non-abstract normal methods can also be created in abstract classes. These methods can be static too.
    public static void print(){
        System.out.println("This does nothing");
    }
    //7.Using final keyword in abstract class wont make any sense. This is because abstract classes are there to be inherited and hence there is no point in blocking theier inheritance. Using final will hence create an error.
}
