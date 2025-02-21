import java.util.Scanner;

public class E_Factorial {

    public static int factorial(int number){
        //Base Case
        if(number==1){
            return 1;
        }
        //Recurrence Relation
        return number*factorial(number-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to find its factorial");
        int number=sc.nextInt();
        System.out.println("The factorial is "+factorial(number));
        sc.close();
    }
}
