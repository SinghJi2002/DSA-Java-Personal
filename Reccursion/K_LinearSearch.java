public class K_LinearSearch{
    public static int linearSearch(int[] array,int index,int target){
        //Base Condition 1
        if(index==array.length){
            return -1;
        }
        //Base Condition 2
        if(array[index]==target){
            return index;
        }
        //Recurrence Relation
        return linearSearch(array,index+1,target);
    }
    public static void main(String[] args) {
        int[] array={1,9,7,10,15,6};
        int target=15;
        int index=linearSearch(array,0,target);
        System.out.println("The index of target element is "+index);
    }
}