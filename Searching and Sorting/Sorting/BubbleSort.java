import java.util.Arrays;
public class BubbleSort{
    public static int[] bubbleSort(int[] arr,int n){
        //General Logic is, with every cycle we place largest,second largest,third largest and so on to 
        //the right. Here we compare adjacent elements,and then swap them while traversing l to r.
        for(int i=0;i<n-1;i++){
            //This loop controls the cycles. It will run n-1 times where each cycle will ensure,
            //one element being placed at the right position.

            //One basic change that we can implement when there is no swap taking place in a cycle,
            //this basically means that the whole array is sorted, since when adjacent values were 
            //compared, none of them broke the order. Hence, we can then simply halt the whole sorting
            //process.

            boolean swap=false;
            //Assuming no swap will take place.
            for(int j=0;j<n-1-i;j++){
                //This loop is where we will perform adjacent comparisons. Also note it runs,n-1-i times.
                // The reason for using i there is since with each turn the one element gets sorted, 
                //hence there is no need to traverse it. Hence i inclusion is justified.
                if(arr[j+1]<arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    //if a single swap takes place, we turn the swap variable true.
                    swap=true;
                }
            }
            //If after coming out of j swap remains false, this means no swap has taken place and array
            //is already sorted. So we break the process.
            if(!swap){
                break;

            }
        }
        return(arr);
    }

    public static void main(String[] args) {
        int[] arr={1,7,2,4,3,6,5,9};
        int[] sorted_arr=bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(sorted_arr));
    }
}
//Time complexity-O(N^2)
//Space complexity-O(1)