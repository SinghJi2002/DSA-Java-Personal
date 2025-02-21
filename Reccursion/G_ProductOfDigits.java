import java.util.Scanner;

public class G_ProductOfDigits {
    public static int productOfDigits(int n){
        //Base Condition
        if(n%10==n){
            return n;
        }
        //Recurrence Relation
        return n%10*productOfDigits(n/10);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a Number");
        int number=sc.nextInt();
        int product=productOfDigits(number);
        System.out.println("Product Of Digits "+product);
        sc.close();
    }
}
