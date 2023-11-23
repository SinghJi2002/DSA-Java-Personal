package Reccursion;

import java.util.Scanner;

public class CountZeroNumbers {

    public static int CountZeros(int num,int count){
        if(num==0){
            return(count);
        }
        int element=num%10;
        if(element==0){
            num=num/10;
            return(CountZeros(num, ++count));
        }
        else{
            num=num/10;
            return(CountZeros(num, count));
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter Number OF Your Choice");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int count=0;
        int result=CountZeros(num,count);
        System.out.println("The number of zeros are "+result);
    }    
}
