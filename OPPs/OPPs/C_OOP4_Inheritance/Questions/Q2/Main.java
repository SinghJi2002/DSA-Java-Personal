package OPPs.C_OOP4_Inheritance.Questions.Q2;

public class Main {
    public static void main(String[] args) {
        TwoD sheet1=new TwoD(5,6);
        System.out.println(sheet1.costOfSheet());

        ThreeD box1=new ThreeD(5,6,3);
        System.out.println(box1.costOfSheet());
    }
}
