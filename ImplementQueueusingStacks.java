class MyQueue {
    Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> container = new Stack<Integer>();
        while (stack.size() > 1) {
            container.push(stack.pop());
        }
        stack.pop();
        while (!container.isEmpty()) {
            stack.push(container.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> container = new Stack<Integer>();
        while (stack.size() > 1) {
            container.push(stack.pop());
        }
        int firstValue = stack.peek();
        while (!container.isEmpty()) {
            stack.push(container.pop());
        }
        return firstValue;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.size() == 0;
    }
}
