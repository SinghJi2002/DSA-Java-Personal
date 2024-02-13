package OOPs.C_OOP4_Inheritance.Questions.Q1;

public class Box {
    int length;
    int width;
    int heigth;

    public Box(){
        this.width=0;
        this.length=0;
        this.heigth=0;
    }

    public Box(int lenght,int heigth,int width){
        this.length=lenght;
        this.width=width;
        this.heigth=heigth;
    }

    public int volume(){
        return(length*width*heigth);
    }
}
