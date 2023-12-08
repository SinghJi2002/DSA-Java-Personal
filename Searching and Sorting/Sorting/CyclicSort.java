import java.util.Arrays;

public class CyclicSort {

    public static void cyclicSort(int[] arr,int n){
        int i=0;
        //This sort is generally used when we have element from 1...N. The general relation between value
        //stored and index for the array to be sorted is, value=index+1;
        //For instance, if lenght is 5, elements of array will be 1,2,3,4,5 at indexes, 0,1,2,3,4.
        while(i<n){
            if(arr[i]!=i+1){
                //Suppose at index 0,3 is present. Then this condition is true. What we then do is, 
                // put 3 at 3-1 index and swap the value at 3-1 index to current index.
                int temp=arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=temp;
            }
            if(arr[i]==i+1){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,3,5,4,2};
        cyclicSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
