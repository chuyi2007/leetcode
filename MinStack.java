class MinStack {
    Stack<Integer> realStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        realStack.push(x);
        
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = realStack.pop();
        
        if (!minStack.isEmpty() && x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return realStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

