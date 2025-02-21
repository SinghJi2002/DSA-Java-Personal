import java.util.Scanner;

public class H_ReverseANumber {
    public static int numberOfDigits(int n){
        int numDigits=0;
        while(n>0){
            n=n/10;
            numDigits++;
        }
        return(numDigits);
    }
    
    public static int reverseDigits(int n) {
        //Base Condition
        if(n%10==n){
            return n;
        }
        //Recurrence Relation
        return (n%10)*(int)Math.pow(10,numberOfDigits(n)-1)+reverseDigits(n/10);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number");
        int number=sc.nextInt();
        int reverse=reverseDigits(number);
        System.out.println("Reversed Number is "+reverse);
        sc.close();
    }
}
