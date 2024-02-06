package OPPs.C_OOP4_Inheritance.Questions.Q3;

public class Box extends Plate {
    int height;

    public Box(){};

    public Box(int length,int breadth,int height){
        super(length,breadth);
        this.height=height;
        System.out.println("The height of is "+this.height);
    }
}
