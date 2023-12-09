package StackAndQueue.Questions;

import java.util.LinkedList;
import java.util.Stack;

public class ImplementQueueInStack {
    Stack<Integer> stack1=new Stack()<>();
    Stack<Integer> stack2=new Stack<>();

    public void add(int value){
        stack1.push(value);
    }

    public void remove(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int element=stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public void peek(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int element=stack2.peek();
        System.out.println(element);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
}
