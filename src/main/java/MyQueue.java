import java.util.Stack;

public class MyQueue {
    public Stack<Integer> inStack;
    public Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack  = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        dumpsInStack();
        return outStack.pop();
    }
    
    public int peek() {
        dumpsInStack();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void dumpsInStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}