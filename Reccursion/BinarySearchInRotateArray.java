package Reccursion;

public class BinarySearchInRotateArray {

    public static int pivot(int[] arr,int s,int e){
        int mid=s+((e-s)/2);
        while(s<e){
            mid=s+((e-s)/2);
            if(arr[mid]>arr[mid-1]){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return(s);
    }

    public static int binarySearch(int[] arr,int s,int e,int t){
        int mid=s+((e-s)/2);
        if(s>e){
            return(-1);
        }
        if(t==arr[mid]){
            return(mid);
        }
        if(t>arr[mid]){
            return(binarySearch(arr, mid+1, e, t));
        }
        else{
            return(binarySearch(arr, s, mid-1, t));
        }
    }

    public static void main(String[] args) {
        int[] array={5,6,1,2,3,4};
        int target=3;
        int start=0;
        int end=array.length-1;
        int piv=pivot(array, start, end);
        System.out.println(piv);
        int result;
        if(target>array[piv] && target<=array[end]){
            result=binarySearch(array,piv,end,target);
        }
        else if(target>array[piv] && target>=array[start]){
            result=binarySearch(array, start, piv, target);
        }
        else{
            result=piv;
        }
        System.out.println("Index of Element is "+result);

    }
    
}
