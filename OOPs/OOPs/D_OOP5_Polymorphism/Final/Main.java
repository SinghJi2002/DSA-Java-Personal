package OOPs.D_OOP5_Polymorphism.Final;

public class Main {
    public static void main(String[] args) {
        shapes mn=new sqaure();
        //Again a superclass reference and a subclass object.
        mn.area();
        //mn being shapes object by our old defination(Right side type defines access) should access the are method of shapes class but ends up accessing the area method of the square class which originally was not possible. This happend due to dynamic method dispatch and overiding where the area method of square overides the area method of shapes.

        //Dynamic method dispatch: Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than compile time.
    }
}
