package OPPs.C_OOP4_Inheritance;
//We are just creating a parent class for demonstration purposes.
public class Box_Base{
    double l;
    double h;
    double w;

    public Box_Base(){
        this.l=-1;
        this.h=-1;
        this.w=-1;
    }

    public Box_Base(double l,double h,double w){
        this.l=l;
        this.h=h;
        this.w=w;
    }

    public Box_Base(Box_Base old){
        this.l=old.l;
        this.h=old.h;
        this.w=old.w;
    }

    public void information(){
        System.out.println("Box has been created");
    }
}