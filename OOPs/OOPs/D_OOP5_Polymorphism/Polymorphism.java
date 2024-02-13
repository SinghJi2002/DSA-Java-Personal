package OPPs.D_OOP5_Polymorphism;
//Polymorphism means "Many ways to represent". Languages supporting this are called OOL. Else they are called Object Basis Languages.

//Polymorphism is of 2 types. The first is static or Compile time polymorphism. This polymorphism is achieved via method/constructor overloading. This is called compile time because at the time of compilation is when the which method is to be accessed is decided. The other type of polymorphism is Runtime or Dynamic polymorphism. This is enaled via the process of overiding. Overiding is observed when two classes in inheritance have a function having the same name. In that case it is observed that the function in the child class is given preference over the function in the parent class. This phenomenon is called overiding. The "@overide" annotation is a wat to check whether a function/method is being overidden or not.

// Lets try and add something we already know. We know when we write a code where a superclass reference stores a subclass object, the right side defines access, that is in this case superclass reference variable is only able to access whatever is in superclass, mean while if the cases was opposite, the subclass would have been able to access both super and sub class components. 

// Open the example folder and understand a very important concept there.

//Now lets discuss about the final keyword again. This can have 2 functions.
//1) If used before an object in a class then that object cannot be overidden. Useful in increasing performane since it finishes the problem/fear of compiler to come accross similar object.

//2)Can also be used on a class and then inheritance would be impossible. Note that if a class is final, its suggested that its methods showed also be made final.

//See Final folder for demostration.

public class Polymorphism{
    public static void main(String[] args) {
        
    }
}