// Last updated: 13/09/2025, 01:50:32
class MyStack {
    Queue<Integer> q=new LinkedList<>();
    public MyStack() {
        //constructor
    }
    
    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }
    
    public int pop() {
         return q.remove();
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