package OPPs.C_OOP4_Inheritance.Questions.Q3;

public class WoodenBox extends Box {
    int thickness;

    public WoodenBox(){};

    public WoodenBox(int height,int length,int width,int thickness){
        super(length,width,height);
        this.thickness=thickness;
        System.out.println("The thickness is "+this.thickness);
    }
}
