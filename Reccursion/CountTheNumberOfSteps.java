package Reccursion;

import java.util.Scanner;

public class CountTheNumberOfSteps {

    public static int StepCount(int num,int step){
        if(num==0){
            return(step);
        }
        num=num/10;
        step=step+1;
        return(StepCount(num, step));
    }
    public static void main(String[] args) {
        System.out.println("Enter Number Of Your Choice");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int step=0;
        int result=StepCount(num,step);
        System.out.println("The step count is "+result);
    }
    
}
