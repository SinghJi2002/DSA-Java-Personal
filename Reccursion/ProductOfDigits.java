package Reccursion;

import java.util.Scanner;

public class ProductOfDigits {

    public static int productOfDigits(int num,int product){
        if(num==0){
            return(product);
        }
        int element=num%10;
        product=product*element;
        return(productOfDigits(num/10, product));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int num=sc.nextInt();
        int product=1;
        int result=productOfDigits(num,product);
        System.out.println("The product of numbers is "+result);
    }
    
}
