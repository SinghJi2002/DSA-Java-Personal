package Reccursion;

import java.util.ArrayList;
import java.util.Scanner;

public class LinearSearchMultiReccur {

    public static ArrayList<Integer> linearSearch(int[] arr,int lenght,int index,ArrayList<Integer> solutions,int target){
        if(index==lenght){
            return(solutions);
        }
        if(arr[index]==target){
            solutions.add(index);
        }
        return(linearSearch(arr, lenght, ++index, solutions, target));
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of elements you want in the list");
        Scanner sc=new Scanner(System.in);
        int lenght=sc.nextInt();
        int index=0;
        int target=4;
        int[] array=new int[lenght];
        ArrayList<Integer> indexLists=new ArrayList<Integer>();
        for(int j=0;j<lenght;j++){
            System.out.println("Enter element");
            int element=sc.nextInt();
            array[j]=element;
        }
        ArrayList<Integer> result=linearSearch(array,lenght,index,indexLists,target);
        System.out.println("The Indexes Of Interest are");
        for(int i=0;i<indexLists.size();i++){
            System.out.println(result.get(i));
        }
    }
}
