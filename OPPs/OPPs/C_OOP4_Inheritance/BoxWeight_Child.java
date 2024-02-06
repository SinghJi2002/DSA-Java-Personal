package OPPs.C_OOP4_Inheritance;
//Here we are creating child class BoxWeight_Child of base class Box_Base, via the extends keyword.

//What happening when the extention takes place is that the child class will now have the access of the datamembers and constructors and functions of the parent class without them being exclusively being declared in the children class.

public class BoxWeight_Child extends Box_Base {
    
    double weight;
    
    public BoxWeight_Child(){
        this.weight=-1;
    }

    public BoxWeight_Child(double l,double w,double h,double weight){
        //Here we are access the l,w,h variables of parent class of child class. The super keyword being used here is calling constructor of the parent class that takes 3 variables and is initialising each of these values in the children class itself. Note that whenever we use a super keyword in the constructors of the children class it must be the first thing on the program or else error will be generated.
        
        //The super keyword calls the parent class's contructors. For a situation lets say we have the classes a b and c in multi inheritance. Super on c calls b, super on b calls a, but super on a calls class objects which is the superclass for all the classes.
        
        //We know that "this" keyword references object. The super keyword will also do the same, its just that it will emphasise more on the parent class in place of the child class where it is being called. To understand this take this example. Lets say that both the parent class and the child class have the datamember weight. Then this.weight initializes the datamember of child class but  super.weight will initialise the weight datamember of the parent class.
        super(l,h,w);
        this.weight=weight;
    }

    public BoxWeight_Child(BoxWeight_Child box){
        super(box);
        //This calls constructor of parent child box and feed a BoxWeight object into. It is very similar to the case we observed in the case of 
        //Box_Base box3=new BoxWeight_Child(1, 2, 3, 4);
        //In the main class.
    }
}
