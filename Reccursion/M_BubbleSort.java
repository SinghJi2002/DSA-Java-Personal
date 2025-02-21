import java.util.Arrays;

public class M_BubbleSort {
    public static void bubbleSort(int[] arr,int row,int col){
        //Base Case
        if(row==0){
            return;
        }
        
        //Now there are Two routes that we can adopt. For all the cases where col is less than row(signifies we are still finding the correct element to fit a particular index), we will swap elements if neccessary and recursive move our pointer ahead.
        if(col<row){

            //Sorting Logic
            if(arr[col]>arr[col+1]){
                //Swap them
                int temp=arr[col];
                arr[col]=arr[col+1];
                arr[col+1]=temp;
            }
            
            bubbleSort(arr,row,col+1);
        }
        
        //The other way is when row and col become equal(signifies that the correct element for a certain position in the array has been found and its time to move to next index), then we will move to next row and recursive increase our pointer from the start.
        else{
            bubbleSort(arr, row-1, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr={4,3,2,1};
        int row=arr.length-1;
        int col=0;
        bubbleSort(arr, row, col);
        System.out.println(Arrays.toString(arr));
    }
}
