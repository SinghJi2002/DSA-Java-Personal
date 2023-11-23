package StackAndQueue.Questions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TheGameOfTwoStacks {

    public static int twoStacks(int maxSum,int[] stack1,int[] stack2){
        return(twoStacks(maxSum, stack1, stack2, 0, 0));
    }

    public static int twoStacks(int maxSum,int[] stack1,int[] stack2,int currSum,int count){
        if(currSum>maxSum){
            return count;
        }        
        if(stack1.length==0 || stack2.length==0){
            return count;
        }
        int ans1=twoStacks(maxSum, Arrays.copyOfRange(stack2, 1, stack1.length), stack2, currSum+stack1[0], count+1);
        int ans2=twoStacks(maxSum, stack1, Arrays.copyOfRange(stack2,1,stack2.length), currSum+stack2[0], count++);

        return Math.max(ans1, ans2);
    }   
    
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    for (int i = 0; i < t; i++) {
      int n = s.nextInt();
      int m = s.nextInt();
      int x = s.nextInt();
      int[] a = new int[n];
      int[] b = new int[m];
      for (int j = 0; j < n; j++) {
        a[j] = s.nextInt();
      }
      for (int j = 0; j < m; j++) {
        b[j] = s.nextInt();
      }
      System.out.println(twoStacks(x, a, b));
    }
  }
}
