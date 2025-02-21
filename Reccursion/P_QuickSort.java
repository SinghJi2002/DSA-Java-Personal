public class P_QuickSort {
    public static void quickSort(int[] arr,int start,int end){
        //Base Case
        if(start>=end){
            return;
        }

        int s=start;
        int e=end;
        int m=(s+e)/2;
        int pivot=arr[m];

        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
    }    
}
