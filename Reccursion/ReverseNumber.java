package Reccursion;

import java.util.Scanner;

public class ReverseNumber{

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
       System.out.println("Enter n");
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int reverse=0;
       int result=Reverse(n,reverse);
       System.out.println("The reverse of "+n+" is "+result);
    }
}