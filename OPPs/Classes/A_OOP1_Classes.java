package OPPs.Classes;

import java.util.ArrayList;

class student{
    String name;
    int roll=0;
    char gender='F';

    //Duplicate An Object.
    student(student other){
        this.name=other.name;
        this.roll=other.roll;
        this.gender=other.gender;
    }

    //Function Greetinsgs.
    void Greetinsgs(){
        System.out.println("Good Morning "+this.name);
    }

    //A constructor.
    /*student(){
        this.name="Ashutosh Kumar Singh";
        this.roll=2974;
        this.gender='M';
    }*/

    student(String name,int roll,char gender){
        this.name=name;
        this.roll=roll;
        this.gender=gender;
    }

    //Calling another constructor from one constructor.
    student(){
        this("Calling Constructor From Another Constructor",0000,'F');
    }
}

public class A_OOP1_Classes {

    public static void swap_values(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }

    public static void swap_reference(Integer a,Integer b){
        Integer temp=a;
        a=b;
        b=temp;
    }


    public static void main(String[] args) {
        student Ashutosh,Divyansh;

        Ashutosh=new student();

        Divyansh=new student(Ashutosh);
        System.out.println(Divyansh.name);
        System.out.println(Divyansh.roll);
        System.out.println(Divyansh.gender);

        //Primitive Datatypes as objects
        Integer a=24;
        Integer b=28;

        //Final Keyword.
        final int nums=25;
        
        //Final Keyword Object
        final student adarshi=new student();

        //We can easily change the values.
        adarshi.name="Adarshi Kaur";
        adarshi.name="Adarshi Singh";
        adarshi.roll=2888;

        //We cannot reference it to another object.

        //int[] adarshi=new int[5];
        
    
    }
}
