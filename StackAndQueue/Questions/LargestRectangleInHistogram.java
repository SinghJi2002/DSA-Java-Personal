package StackAndQueue.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int[] SmallestElementNext(int[] heights){
        int[] ans=new int[heights.length+1];
        ans[heights.length]=0;
        for(int i=0;i<heights.length;i++){
            for(int j=i+1;i<heights.length-1;j++){
                if(heights[j]<heights[i]){
                    ans[i]=j;
                    break;
                }
            }

        
        }
        return(ans);
    }

    public static int[] SmallestElementPrev(int[] heights){
        Stack<Integer> newStack=new Stack<Integer>();
        int[] ans=new int[heights.length];
        newStack.push(-1);
        for(int i=0;i<heights.length;i++){
            int currElement=heights[i];
            while(newStack.peek()>=currElement){
                newStack.pop();
            }
            ans[i]=newStack.peek();
            newStack.push(currElement);
        }
        return(ans);

    }

    public static int LargestRectangleInHistogram1(int[] heights){
        int[] SmallestElementNext=new int[heights.length];
        int[] SmallestElementPrev=new int[heights.length];

        SmallestElementNext=SmallestElementNext(heights);
        System.out.println(Arrays.toString(SmallestElementNext));
        SmallestElementPrev=SmallestElementPrev(heights);
        System.out.println(Arrays.toString(SmallestElementPrev));

        int area=-99;
        for(int i=0;i<heights.length;i++){
            int height=heights[i];
            if(SmallestElementNext[i]==-1){
                SmallestElementNext[i]=heights.length;
            }
            int breadth=SmallestElementNext[i]-SmallestElementPrev[i]-1;
            int newArea=height*breadth;
            if(area>newArea){
                area=area;
            }
            else{
                area=newArea;
            }
        }
        return(area);
    }

    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(LargestRectangleInHistogram1(heights));
    }
}
