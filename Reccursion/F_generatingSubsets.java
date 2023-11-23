package Reccursion;

import java.util.ArrayList;

public class F_generatingSubsets {

    public static ArrayList<ArrayList<Integer>> subsets(int[] arrays){
        ArrayList<ArrayList<Integer>> solution=new ArrayList<ArrayList<Integer>>();
        solution.add(new ArrayList<>());
        for(int nums:arrays){
            int n=solution.size();
            for(int i=0;i<n;i++){
                ArrayList<Integer> internal=new ArrayList<Integer>(solution.get(i));
                internal.add(nums);
                solution.add(internal);
            }
        }
        return(solution);
    }

    public static void main(String[] args) {
        int[] arrays={1,2,3};
        ArrayList<ArrayList<Integer>> solution=subsets(arrays);
        for(int i=0;i<solution.size();i++){
            ArrayList<Integer> part=solution.get(i);
            System.out.println(part);
        }
    }
    
}
