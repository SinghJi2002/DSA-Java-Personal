package OOPs.C_OOP4_Inheritance.Questions.Q2;

public class TwoD {
    int length;
    int breadth;
    int costPerSq2=40;

    public TwoD(){};

    public TwoD(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
    }

    public int costOfSheet(){
        return(length*breadth*costPerSq2);
    }
}
