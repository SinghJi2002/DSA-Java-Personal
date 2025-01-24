class dynamicStack{
    private int dynamicArray[];
    private int defaultSize;
    int pointer=-1;

    //Create dynamic stack
    public dynamicStack(int size){
        defaultSize=size;
        this.dynamicArray=new int[size];
    }

    //Enter element
    public boolean push(int value){
        if(isFull()){
            int newStack[]=new int[defaultSize*2];
            for(int i=0;i<dynamicArray.length;i++){
                newStack[i]=dynamicArray[i];
            }

            pointer++;
            dynamicArray=newStack;
            dynamicArray[pointer]=value;
            return(true);
        }
        pointer++;
        dynamicArray[pointer]=value;
        return(true);
    }

    public boolean isFull(){
        if(pointer==dynamicArray.length-1){
            return(true);
        }
        return(false);
    }

    //Remove Element
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty, hence nothing more can be deleted");
            return(-1);
        }
        int element=dynamicArray[pointer];
        pointer--;
        return(element);
    }

    public boolean isEmpty(){
        if(pointer==-1){
            return(true);
        }
        return(false);
    }

    //Peek element
    public void peek(){
        if(isEmpty()){
            System.out.println("Nothing to see");
            return;
        }
        System.out.println(dynamicArray[pointer]);
    }

    public static void main(String[] args) {
        dynamicStack stack=new dynamicStack(5);
        stack.push(10);
        stack.peek();
        stack.push(10);
        stack.peek();
        stack.push(10);
        stack.peek();
        stack.push(10);
        stack.peek();
        stack.push(10);
        stack.peek();
        stack.push(10);
        stack.peek();
        stack.push(10);
        stack.peek();
        stack.push(10);
        stack.peek();
        stack.pop();
        stack.peek();
    }
}
