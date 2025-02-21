public class J_CheckArraySorted {
    public static boolean checkSorted(int[] array,int index){
        //Base Condition
        if(index==array.length-1){
            return true;
        }
        //Recurrence Relation
        return array[index]<=array[index+1] && checkSorted(array,index+1);
    }

    public static void main(String[] args) {
        int[] array1={1,4,5,8,9};
        int[] array2={1,3,7,5,6};
        if(checkSorted(array1, 0)){
            System.out.println("Array 1 Sorted");
        }
        else{
            System.out.println("Array 1 not Sorted");
        }

        if(checkSorted(array2, 0)){
            System.out.println("Array 2 Sorted");
        }
        else{
            System.out.println("Array 2 not Sorted");
        }
    }
}
