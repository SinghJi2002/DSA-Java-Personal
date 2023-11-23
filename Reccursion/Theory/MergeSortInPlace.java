package Reccursion.Theory;

import java.util.Arrays;

public class MergeSortInPlace {

    public static void mergeSort(int[] unsortedArray,int s,int m,int e){
        int leftCounter=0;
        int rightCounter=m;
        int[] sol=new int[e-s];
        int index=0;
        while(leftCounter<m && rightCounter<e){
            if(unsortedArray[leftCounter]<unsortedArray[rightCounter]){
                sol[index]=unsortedArray[leftCounter];
                index++;
                leftCounter++;
            }
            else{
                sol[index]=unsortedArray[rightCounter];
                index++;
                rightCounter++;
            }
        }
        while(leftCounter<m){
            sol[index]=unsortedArray[leftCounter];
            leftCounter++;
            index++;
        }
        while(rightCounter<e){
            sol[index]=unsortedArray[rightCounter];
            rightCounter++;
            index++;
        }
        for(int l=0;l<unsortedArray.length;l++){
            unsortedArray[s+l]=sol[l];
        }

    }

    public static void inPlaceMergeSort(int[] unsortedArray,int s,int e){
        if(e-s==1){
            return;
        }
        int m=(e+s)/2;
        inPlaceMergeSort(unsortedArray, s, m);
        inPlaceMergeSort(unsortedArray, m, e);
        
        mergeSort(unsortedArray,s,m,e);
    }

    public static void main(String[] args) {
        int[] unsortedArray={1,6,5,2,4,3};
        int start=0;
        int end=unsortedArray.length;
        inPlaceMergeSort(unsortedArray,start,end);
        System.out.println(Arrays.toString(unsortedArray));
    }
    
}
