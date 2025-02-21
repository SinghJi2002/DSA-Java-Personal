import java.util.Scanner;

public class F_SumOfDigits {
    
    public static int sumOfDigits(int n){
        //Base Case
        if(n==0){
            return 0;
        }
        //Recurrence Relation
        return n%10+sumOfDigits(n/10);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number");
        int number=sc.nextInt();
        int sum=sumOfDigits(number);
        System.out.println("Sum Of Digits "+sum);
        sc.close();
    }
}
