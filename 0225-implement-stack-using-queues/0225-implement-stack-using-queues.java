class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList();
    }
    
    public void push(int x) {
        Queue<Integer> p = new LinkedList();
        while(!q.isEmpty())
        {
            p.add(q.peek());
            q.remove();
        }
        q.add(x);
        while(!p.isEmpty())
        {
            q.add(p.peek());
            p.remove();
        }
    }
    
    public int pop() {
        int top = q.peek();
        q.remove();
        return top;
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */