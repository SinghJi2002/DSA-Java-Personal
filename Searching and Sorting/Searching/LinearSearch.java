import java.util.Scanner;

public class LinearSearch{

    public static int linearSearch(int[] arr,int n){
        int index=0;
        int lenght=arr.length;
        while (index<lenght) {
            if(arr[index]==n){
                System.out.println("Element found");
                return(index);
            }
            index++;
        }
        return(-1);
    }
    public static void main(String[] args) {
        int[] arr={1,2,5,7,3,4,9};
        System.out.println("Enter the element you want to search");
        Scanner sc=new Scanner(System.in);
        int search=sc.nextInt();
        int index=linearSearch(arr,search);
        if(index==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element at index "+index);
        }
    }
}