class MyQueue {
    Stack<Integer> is = new Stack();
    Stack<Integer> os = new Stack();
    // Push element x to the back of queue.
    public void push(int x) {
        is.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!os.isEmpty()) {
            os.pop();
        }
        else {
            while(!is.isEmpty()) {
                os.push(is.pop());
            }
        }
    }

    // Get the front element.
    public int peek() {
        if (!os.isEmpty()) {
            return os.top();
        }
        else {
            while(!is.isEmpty()) {
                os.push(is.pop();
            }
            
            return os.top();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return is.isEmpty() && os.isEmpty();
    }
}