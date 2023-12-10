/*This is a non-comparison based sorting algorithm. That is unlike the previous sorting methods where we compare and sort the elements,
here we don't do that. This is generally good for sorting of small numbers.
The general algorithm is:
1)In the given array, search for the largest element.
2)Create a new array of size (largest element + 1). This will be frequency array.
3)Traverse the original array, calculate the frequency of each element, and update the frequency corresponding to the index.
For instance, say the frequency of 2 in original array, is 3.
Then, in the frequency array, update 0 by 3 in index 2.
Do this for all the elements.
4)Create a new array, or you know take the original array itself. Now from the frequency array, start updating the elements.
For instance, frequency array is,
{0,3,1,2,1}
 0 1 2 3 4-Corresponding index.
Then sorted array will be,
{1,1,1,2,3,3,4}
Then time complexity is O(n+m)
Space complexity, best case is O(1) and worst is O(N).
 */

import java.util.Arrays;

public class CountSort {
    public static int[] Sort(int[] arr){
        //Finding Maximum Element 
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //Creating the frequency array
        int[] frequencyArray=new int[max+1];
        //Updating frequency array
        for(int j=0;j<arr.length;j++){
            frequencyArray[arr[j]]++;
        }
        //Creating new sorted array
        int[] sortedArray=new int[arr.length];
        int index=0;
        int freqArr_index=0;
        while(index<arr.length){
            while(frequencyArray[freqArr_index]!=0){
                sortedArray[index]=freqArr_index;
                frequencyArray[freqArr_index]--;
                index++;
            }
            freqArr_index++;
        }
        return(sortedArray);
    }

    //Check code
    public static void main(String[] args) {
        int[] arr={1,2,3,1,4,3,1};
        int[] sor_arr=Sort(arr);
        System.out.println(Arrays.toString(sor_arr));
    }
}
