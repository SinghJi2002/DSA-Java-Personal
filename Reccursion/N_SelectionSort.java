import java.util.Arrays;

public class N_SelectionSort {
    public static void selectionSort(int[] arr,int row,int col,int minIndex){
        //Base Condition
        if(row==arr.length-1){
            return;
        }

        //There are two ways of recalling the function. One is keep the row fixed, and move through the column(This signifies that we are in a phase of traversing through the array and selecting the minimum element in the unsorted section of the array)
        if(col<arr.length){
            //Search the smallest element via traversing through the array one index at each recursive call.
            if(arr[col]<arr[minIndex]){
                minIndex=col;
            }

            //recursive call
            selectionSort(arr, row, col+1, minIndex);
        }
        //The other way to call is to reset the row to the next row(row+1) and reset the column variable at the point where unsorted array starts.
        else{
            //Swap the current index element pointed by row, with the element pointed by minIndex in the array.
            int temp=arr[row];
            arr[row]=arr[minIndex];
            arr[minIndex]=temp;

            //Recursive call
            selectionSort(arr, row+1, row+1, row+1);
        }
    }

    public static void main(String[] args) {
        int[] arr={1,4,7,2,3,6};
        selectionSort(arr, 0, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
}
