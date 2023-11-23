package Reccursion;

import java.util.Scanner;

public class BubbleSortReccur {

    public static int[] bubbleSort(int[] arr,int cycles,int step,int currCycle){
        if(currCycle==cycles){
            return(arr);
        }
        if(step<cycles-currCycle){
            if(arr[step]>arr[step+1]){
                int temp=arr[step];
                arr[step]=arr[step+1];
                arr[step+1]=temp;
                return(bubbleSort(arr, cycles, ++step, currCycle));
            }
            else{
                return(bubbleSort(arr, cycles, ++step, currCycle));
            }
        }
        else{
            return(bubbleSort(arr, cycles, 0, ++currCycle));
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Enter the number of element you want in the array");
        Scanner sc=new Scanner(System.in);
        int lenght=sc.nextInt();
        int[] array=new int[lenght];
        for(int j=0;j<lenght;j++){
            System.out.println("Enter Element");
            int element=sc.nextInt();
            array[j]=element;
        }
        int cycles=lenght-1;
        int step=0;
        int currCycle=0;
        int[] result=bubbleSort(array, cycles, step,currCycle);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}

