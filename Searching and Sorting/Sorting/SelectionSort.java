import java.util.Arrays;

public class SelectionSort{
    
    public static void selectionSort(int[] arr,int n){
        //General intuition is, pick a element and put it at its right index.
        //Algorithm is,
        /*
        1)Run n number of cycles with each cycle sorting 1 element.
        2)In sorting, first sort the last index. For this find the largest element. Then swap the last
        index value with largest element. And place the element placed at last index at current index
        of the largest element.
        3)In next cycle, ignore the last element(n-1-i).
        Continue this for n cycles.
        */
        for(int i=0;i<n;i++){
            //Finding the largest,2nd largest... elements as cycles go on.
            int currMax=i;
            for(int j=0;j<n-i;j++){
                if(arr[j]>arr[currMax]){
                    currMax=j;
                }
            }
            //Now I have the index on which current range maximum element is. Will swap now.
            int temp=arr[n-1-i];
            arr[n-i-1]=arr[currMax];//n last index element save at n large element's currIndex.
            arr[currMax]=temp;//nth largest element placed at nth index from the last
        }
    }
    public static void main(String[] args) {
        int[] arr={1,7,2,4,3,6,5,9};
        selectionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));    
    }
}