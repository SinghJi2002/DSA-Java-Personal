import java.util.Arrays;

public class O_MergeSort {

    public static int[] merge(int[] arr1,int[] arr2){
        //Lenght of merged array
        int lenNewArray=arr1.length+arr2.length;

        //New mergedArray
        int[] mergedArray=new int[lenNewArray];

        //Two pointers to traverse the two arrays.
        int pointer1=0;
        int pointer2=0;

        //Index pointer to add elements in the merged 
        int index=0;

        //Adding elements until both arrays have elements.
        while(pointer1<arr1.length && pointer2<arr2.length){
            if(arr1[pointer1]<arr2[pointer2]){
                mergedArray[index]=arr1[pointer1];
                pointer1++;
            }
            else{
                mergedArray[index]=arr2[pointer2];
                pointer2++;
            }
            index++;
        }

        //Adding leftover elements of arr1 at the end of mergedArray
        while(pointer1<arr1.length){
            mergedArray[index]=arr1[pointer1];
            pointer1++;
            index++;
        }

        //Adding leftover elements of arr2 at the end of mergedArray
        while(pointer2<arr2.length){
            mergedArray[index]=arr2[pointer2];
            pointer2++;
            index++;
        }

        //returning the merged array
        return mergedArray;
    }

    public static int[] mergeSort(int[] arr){
        //Further division of array is not possible if the length is one. This will be our base condition.
        if(arr.length==1){
            return arr;
        }

        //These are the indexes according to which we will divide the array into 2 halfs.
        int start=0;
        int end=arr.length;
        int mid=arr.length/2;

        //Creating the two half arrays.
        int[] rightHalfArray=Arrays.copyOfRange(arr, start, mid);
        int[] leftHalfArray=Arrays.copyOfRange(arr, mid, end);

        //Calling the mergeSort function of the left half first.
        int[] leftSortedArray=mergeSort(leftHalfArray);
        
        //Calling the mergeSort function for the right half next.
        int[] rightSortedArray=mergeSort(rightHalfArray);

        //After we have left and right sorted arrays we will merge them and return them.
        return merge(leftSortedArray,rightSortedArray);
    }   
    
    public static void main(String[] args) {
        int[] arr={8,3,4,12,5,6};
        int[] sortedArray=mergeSort(arr);
        System.out.println(Arrays.toString(sortedArray));
    }
}
