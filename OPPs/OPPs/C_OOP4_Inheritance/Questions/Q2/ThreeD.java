package OPPs.C_OOP4_Inheritance.Questions.Q2;

public class ThreeD extends TwoD {
    int heigth;
    int costPerSq3=60;
    public ThreeD(){};

    public ThreeD(int length,int width,int heigth){
        super(length,width);
        this.heigth=heigth;
    }

    public int costOfSheet(){
        return(length*breadth*heigth*costPerSq3);
    }
}
