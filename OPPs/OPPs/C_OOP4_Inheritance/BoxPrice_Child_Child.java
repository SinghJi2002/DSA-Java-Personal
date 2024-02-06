package OPPs.C_OOP4_Inheritance;

public class BoxPrice_Child_Child extends BoxWeight_Child {
    int price;
    public BoxPrice_Child_Child(){
        super();
        this.price=-1;
    }

    public BoxPrice_Child_Child(BoxPrice_Child_Child other){
        super(other);
        this.price=other.price;
    }

    public BoxPrice_Child_Child(double l,double h,double w,double weight,int price){
        super(l,h,w,weight);
        this.price=price;
    }
}
