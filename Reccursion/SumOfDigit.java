package Reccursion;

import java.util.Scanner;

public class SumOfDigit {

    public static int sumOfDigits(int num,int sum){
        if(num==0){
            return(sum);
        }
        int element=num%10;
        sum=sum+element;
        num=num/10;
        return(sumOfDigits(num, sum));
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        int s=0;
        int sum=sumOfDigits(n,s);
        System.out.println("The sum of the digits of the numbers is "+sum);       
    }
    
}
