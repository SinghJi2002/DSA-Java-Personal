class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class Stack {
    Node start;
    int currSize = 0;

    public Stack() {
        System.out.println("New Stack Is Created");
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = start;
        start = newNode;
        currSize++;
    }

    public int pop() {
        if (start == null) {
            System.out.println("The stack is empty");
            return (-1);
        }
        int valueToReturn = start.value;
        start = start.next;
        currSize--;
        return (valueToReturn);
    }

    public int size() {
        return (currSize);
    }

    public int top() {
        if (start == null) {
            System.out.println("The stack is empty");
            return (-1);
        }
        return (start.value);
    }
}

public class C_ImplementingStackUsingLinkedList {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // 3
        System.out.println("Stack size: " + stack.size()); // 3

        System.out.println("Popped: " + stack.pop()); // 3
        System.out.println("Top element: " + stack.top()); // 2
        System.out.println("Stack size: " + stack.size()); // 2

        stack.pop();
        stack.pop();
        System.out.println("Popped from empty stack: " + stack.pop()); // -1
    }
}
