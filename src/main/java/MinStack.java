import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min_stack.empty() || min_stack.peek() >= x)
            min_stack.push(x);
    }

    public void pop() {
        if (min_stack.peek().equals(stack.peek()))
            min_stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}


