package Reccursion;

import java.util.Scanner;

public class Palindrome {

    public static int Reverse(int num,int reverse){
        if(num==0){
            return(reverse);
        }
        int remainder=num%10;
        reverse=reverse*10+remainder;
        num=num/10;
        return(Reverse(num, reverse));
    }
    
    public static void main(String[] args) {
        System.out.println("Enter number of your choice");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int reverse=0;
        int result=Reverse(num,reverse);
        if(num==result){
            System.out.println("Palindrome Number");
        }
        else{
            System.out.println("Not a Palindrome Number");
        }
    }
}
