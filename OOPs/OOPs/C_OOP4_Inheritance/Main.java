package OOPs.C_OOP4_Inheritance;

import javax.swing.Box;

public class Main {
    public static void main(String[] args) {

        BoxWeight_Child box1=new BoxWeight_Child();

        BoxWeight_Child box2=new BoxWeight_Child(1,2,3,5);

        Box_Base box3=new BoxWeight_Child(1, 2, 3, 4);
        //System.out.println(box3.l+" "+box2.w+" "+box3.h+" "+box3.weight);
        
        //In the code above we see that a Box reference is containing a BoxWeight object. Till this its all right. What we see here is we are able to intialise all the four datamembers but at the time we are trying to access the these datamembers, we are able to access all of them except for weight(un comment the code above to see). This is because reference variable type defines what all what all datamembers and functions and constructor we could access. Since, Box contains of w,l,h we can access them but it isnt that case with weight, hence we are not able to access it. As for case with ability to initialise is because we are calling the constructor.
        //At the same time its the object class that defines which function/datamember/constructor is to be overiden. 
        
        //BoxWeight_Child box4=new Box(1,2,3);
        //(Un comment to understand.) The counter anology to the previous case is, the child does knows about the parent at all, hence could neither store the parent object, though it can access its properties.
        
        System.out.println(box2.w);
    }
    
}
