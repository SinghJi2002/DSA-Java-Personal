import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] unsortedArray,int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+(high-low))/2;
        int pivot=unsortedArray[mid];
        int s=low;
        int e=high;
        while(s<=e){
            while(unsortedArray[s]<pivot){
                s++;
            }
            while(unsortedArray[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp=unsortedArray[s];
                unsortedArray[s]=unsortedArray[e];
                unsortedArray[e]=temp;
                s++;
                e--;
            }
        }
        quickSort(unsortedArray, low, e);
        quickSort(unsortedArray, s, high);
    }

    public static void main(String[] args) {
        int[] unsortedArray={1,5,4,2,3};
        int low=0;
        int high=unsortedArray.length-1;
        quickSort(unsortedArray,low,high);
        System.out.println(Arrays.toString(unsortedArray));
    }
    
}
