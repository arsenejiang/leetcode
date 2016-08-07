class MyStack {
    Queue<Integer> q = new LinkedList();
    
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
        for(int i = 1; i < q.size(); i++) {
            q.offer(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}