package Reccursion;

import java.util.Scanner;

public class CheckArraySorted {

    public static boolean ifSorted(int[] arr,int index,int lenghts){
        if(index<lenghts){
            if(arr[index]>arr[index-1]){
                return(ifSorted(arr, index+1, lenghts));
            }
            else{
                return(false);
            }
        }
        else{
            return(true);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of element you want");
        Scanner sc=new Scanner(System.in);
        int lenghts=sc.nextInt();
        int array[]=new int[lenghts];
        int index=1;
        for(int i=0;i<lenghts;i++){
            System.out.println("Enter element of your choice");
            int element=sc.nextInt();
            array[i]=element;
        }
        boolean result=ifSorted(array,index,lenghts-1);
        if(result){
            System.out.println("Sorted");
        }
        else{
            System.out.println("Not Sorted");
        }
    }
    
}
