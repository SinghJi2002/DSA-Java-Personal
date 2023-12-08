import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] arr,int n,int s,int e){
        while(s<=e){
            int m=(s+e)/2;
            if(n>arr[m]){
                s=m+1;
                binarySearch(arr, n, s, e);
            }
            else if(n<arr[m]){
                e=m-1;
                binarySearch(arr, n, s, e);
            }
            else if(n==arr[m]){
                return(m);
            }
        }
        return(-1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,6,7,8,9};
        //The basic condition of implementing binary search is that the array should be sorted.
        System.out.println("Enter number to search");
        Scanner sc=new Scanner(System.in);
        int search=sc.nextInt();
        //Binary Search variables
        int start=0;
        int end=arr.length-1;
        int index=binarySearch(arr,search,start,end);     
        if(index==-1){
            System.out.println("Element not present");
        }
        else{
            System.out.println("Element present at "+index);
        }      
    }
}
