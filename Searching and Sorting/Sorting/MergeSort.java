import java.util.Arrays;

public class MergeSort{

    public static int[] merge(int[] left,int[] right){
        int leftCount=0;
        int rightCount=0;
        int leftLimit=left.length;
        int rightLimit=right.length;
        int[] solution=new int[leftLimit+rightLimit];
        int index=0;
        while(leftCount<leftLimit && rightCount<rightLimit){
            if(left[leftCount]<right[rightCount]){
                solution[index]=left[leftCount];
                index++;
                leftCount++;
            }
            else{
                solution[index]=right[rightCount];
                index++;
                rightCount++;
            }
        }
        while(leftCount<leftLimit){
            solution[index]=left[leftCount];
            leftCount++;
            index++;
        }
        while(rightCount<rightLimit){
            solution[index]=right[rightCount];
            rightCount++;
            index++;
        }
        return(solution);
    }

    public static int[] mergeSort(int[] unsortedArray){
        //First check whether the lenght is 1 or not, or else we need to return the array as it is.
        if(unsortedArray.length==1){
            return(unsortedArray);
        }

        int midPoint=(unsortedArray.length)/2;
        int[] arrayPart1=mergeSort(Arrays.copyOfRange(unsortedArray, 0, midPoint));
        int[] arrayPart2=mergeSort(Arrays.copyOfRange(unsortedArray, midPoint, arrayPart1.length));

        return(merge(arrayPart1,arrayPart2));
    }

    public static void main(String[] args) {
        int[] unsortedArray={4,5,1,7,6,9};
        //We will pass this to the mergeSort function to check.
        int[] sortedArray=mergeSort(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}
    