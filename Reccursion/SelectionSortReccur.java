package Reccursion;

public class SelectionSortReccur {

    public static int[] selectionSort(int[] arr,int cycle,int currCycle,int step,int minPos){
        if(currCycle==cycle){
            return(arr);
        }
        if(step<cycle){
            if(arr[minPos]>arr[step]){
                minPos=step;
                return(selectionSort(arr, cycle, currCycle, ++step, minPos));
            }
            else{
                return(selectionSort(arr, cycle, currCycle, ++step, minPos));
            }
        }
        else{
            int temp=arr[currCycle];
            arr[currCycle]=arr[minPos];
            arr[minPos]=temp;
            return(selectionSort(arr, cycle, ++currCycle, step=currCycle+1, currCycle));
        }
    }

    public static void main(String[] args) {
        int[] array={4,1,3,5,2};
        int cycle=array.length;
        int currCycle=0;
        int minPos=currCycle;
        int step=currCycle+1;
        int[] result=selectionSort(array,cycle,currCycle,step,minPos);
        for(int i=0;i<result.length;i++){
            System.out.println(array[i]);
        }
    }
    
}
