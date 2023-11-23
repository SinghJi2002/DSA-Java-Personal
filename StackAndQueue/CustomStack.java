package StackAndQueue;

public class CustomStack{
    public int[] stackArray;
    private static final int Default_Size=10;
    int pointer=-1;
    

    //The following are two constructors that make the underlying structure of stacks,arrays
    public CustomStack(int size){
        this.stackArray=new int[size];
    }

    public CustomStack(){
        this(Default_Size);
    }

    //Now we work with some of the most important function that we implement in stacks
    //Push elements
    public boolean push(int value){
        if(isFull()){
            System.out.println("The array is full, no more elements can be stored");
            return(false);
        }
        pointer++;
        stackArray[pointer]=value;
        return(true);
    }

    public boolean isFull(){
        if(pointer==stackArray.length-1){
            return(false);
        }
        else{
            return(true);
        }
    }

    //Pop elements
    public int pop(){
        if(isEmpty()){
            System.out.println("The stack is empty, hence nothing can be removed");
            return(-1);
        }
        int element=stackArray[pointer];
        pointer--;
        return(element);
    }

    public boolean isEmpty(){
        if(pointer==-1){
            System.out.println("The list is empty, hence nothing can be popped");
            return(false);
        }
        else{
            return(true);
        }
    }

    //Peek at elements
    public void peek(){
        if(isEmpty()){
            System.out.println("Nothing to print");
            return;
        }
        System.out.println(stackArray[pointer]);
    }

    public static void main(String[] args) {
        CustomStack stacks=new CustomStack(10);
        stacks.push(1);
        stacks.peek();
    }
    
}
