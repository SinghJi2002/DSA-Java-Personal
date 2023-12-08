import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr, int n){
        //The general intuition is, we take a cycle variable i, define a internal loop variable j, which
        //is always greater than i by 1 decends in value while sorting elements to its left(j--).
        //The general intuition behined insertion sort is to sort (i+1)th part of array with each iteration
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                //This loop sorts to its left via swaping.
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else{
                    break;
                    //For any situation, when (i-1)th is less than the ith element we break the loop since
                    //the left of the j is already sorted.
                }
            }
        }
    }
     
    public static void main(String[] args) {
        int[] arr={1,7,2,4,3,6,5,9};
        insertionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
