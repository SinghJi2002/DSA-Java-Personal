package Reccursion;

public class BinarySearch {

    public static int binarySearch(int[] arr,int target,int s,int e){
        if(s>e){
            return(-1);
        }
        int mid=s+((e-s)/2);
        if(arr[mid]==target){
            return(mid);
        }
        if(target>arr[mid]){
            return(binarySearch(arr, target, mid+1, e));
        }
        else{
            return(binarySearch(arr, target, s, mid-1));
        }
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9};
        int target=7;
        int start=0;
        int end=arr.length-1;
        System.out.println(binarySearch(arr,target,start,end));
    }
}
