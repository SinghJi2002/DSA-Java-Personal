class Stack{
    int top=-1;
    int length;
    int[] stack;

    public Stack(int sizeOfStack){
        this.length=sizeOfStack;
        stack=new int[length];
    }

    public void push(int number){
        if(top==length-1){
            System.out.println("Stack Overflow");
            return;
        }
        top=top+1;
        stack[top]=number;
        
    }
    
    public int pop(){
        if(top==-1){
            System.out.println("There is no element in the stack to pop");
            return(-1);
        }
        int numberToReturn=stack[top];
        top=top-1;
        return(numberToReturn);
    }

    public int size(){
        if(top==-1){
            return(0);
        }
        return(top+1);
    }

    public int top(){
        if(top==-1){
            System.out.println("There is no element in the stack to show");
            return(-1);
        }
        return(stack[top]);
    }
}


public class A_ImplementStackUsingArray{
    public static void main(String args[]){
        Stack newStack =new Stack(10);
        newStack.push(10);
        newStack.push(9);
        System.out.println(newStack.top());
        newStack.push(8);
        newStack.push(7);
        System.out.println(newStack.size());
        newStack.push(6);
        newStack.push(5);
        newStack.push(4);
        newStack.push(3);
        System.out.println(newStack.top());
        newStack.push(2);
        newStack.push(1);
        newStack.push(0);
        System.out.println(newStack.size());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.size());
        System.out.println(newStack.top());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
    }
}