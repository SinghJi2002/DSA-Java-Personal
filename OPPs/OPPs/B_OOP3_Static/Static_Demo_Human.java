package OPPs.B_OOP3_Static;

public class Static_Demo_Human {
    //Lets write some properties of human class
    String name;
    int age;
    float length;
    float weight;
    //This properties are object centric. That is these values will be different for different objects. That is, it will be different for an object "Ashutosh" and "Divyansh".
    //Though there will be certain properties that do not differ from object to object, but same for all the objects. In this instance say "Population" is such property. Such properties/variables are known as static properties. Now these can be variable, class, methods. Here is an example of use declaring an static property.
    static long population=0;

    //Lets make constructors.
    Static_Demo_Human(String name,int age,float length,float weight){
        this.name=name;
        this.age=age;
        this.length=length;
        this.weight=weight;
        //Now when access a static variable, in place of this we use the class name itself, since its not a object property but a class property. 
        Static_Demo_Human.population++;
        //Though note that "this" can also be used. Though the convention is to use the class name. 
    }

    public static void main(String[] args) {
        Static_Demo_Human ashutosh=new Static_Demo_Human("Ashutosh", 21, 181, 87);
        Static_Demo_Human divyansh=new Static_Demo_Human("Divyansh", 21, 181, 80);
        System.out.println(ashutosh.population);
        System.out.println(divyansh.population);
        System.out.println(ashutosh.name);
        System.out.println(divyansh.name);
        //Note how static variable value remains same for both objects unlike non-static variables. Though since the convention to access static variables is usage of class Name, the population print statements can be changed to,
        System.out.println(Static_Demo_Human.population);
        //Hence static can be defined as, When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object. You can declare both methods and variables to be static.
    }
}
