package Reccursion;

import java.util.Scanner;

public class LinearSeachReccursion {

    public static boolean search(int[] arr,int lenght,int index,int target){
        if(index<lenght-1){
            if(arr[index]==target){
                return(true);
            }
            else{
                return(search(arr, lenght, index+1, target));
            }
        }
        else{
            return(false);
        }
}

    public static void main(String[] args) {
        System.out.println("Enter Number Of Elemen You Want In The Array");
        Scanner sc=new Scanner(System.in);
        int lenght=sc.nextInt();
        int arrays[]=new int[lenght];
        int index=0;
        int target=10;
        for(int i=0;i<lenght;i++){
            System.out.println("Enter Element Of Array");
            int element=sc.nextInt();
            arrays[i]=element;
        }
        boolean result=search(arrays,lenght,index,target);
        if(result){
            System.out.println("Element Found");
        }
        else{
            System.out.println("Element not found");
        }
    }
    
}
