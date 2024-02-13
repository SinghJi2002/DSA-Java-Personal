package OOPs.D_OOP5_Polymorphism.Example;

public class shapes {
    //Area method here is neccessary. The thesis that superclass cant access subclass objects is true but in situation where the methods of superclass and subclass have the same name, access is possible via dynamic method dispatch and overiding. Hence to access the area of square, its neccessary we have a area method here.
    public void area(){
        System.out.println("We are in shapes");
    }
}
