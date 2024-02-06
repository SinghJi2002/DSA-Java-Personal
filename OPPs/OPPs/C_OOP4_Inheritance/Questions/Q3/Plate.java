package OPPs.C_OOP4_Inheritance.Questions.Q3;

public class Plate {
    int length;
    int breadth;

    public Plate(){};
    
    public Plate(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
        System.out.println("The length is "+this.length);
        System.out.println("The breadth is "+this.breadth);
    }
}
