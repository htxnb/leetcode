package leetcode.stack;

/**
 * @ClassName ImplementQueueUsingStacks
 * @Author htx
 * @Date 2018/10/7 22:03
 * @Version 1.0
 **/
public class ImplementQueueUsingStacks {
    private Stack pushStack;
    private Stack pollStack;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks(int capacity) {
        this.pushStack = new Stack(capacity);
        this.pollStack = new Stack(capacity);
    }
    public ImplementQueueUsingStacks() {
        this.pushStack = new Stack();
        this.pollStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(this.pushStack.isFull()){
            throw new RuntimeException("queue is full!");
        }else{
            this.pushStack.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.pushStack.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else{
            int size = this.pushStack.size();
            for (int i = 0; i < size; i++) {
                this.pollStack.push(this.pushStack.pop());
            }
            int pop = this.pollStack.pop();
            int pollStackSize = this.pollStack.size();
            for (int i = 0; i < pollStackSize; i++) {
                this.pushStack.push(this.pollStack.pop());
            }
            return pop;
        }
    }

    /** Get the front element. */
    public int peek() {
        if(this.pushStack.isEmpty()){
            throw new RuntimeException("queue is empty!");
        }else {
            int pushStackSize = this.pushStack.size();
            for (int i = 0; i < pushStackSize; i++) {
                this.pollStack.push(this.pushStack.pop());
            }
            int peek = this.pollStack.peek();
            int pollStackSize = this.pollStack.size();
            for (int i = 0; i < pollStackSize; i++) {
                this.pushStack.push(this.pollStack.pop());
            }
            return peek;
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty();
    }

    public static void main(String[] args) {
//        Stack stack = new Stack();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.isFull());
//        System.out.println(stack.peek());
//        stack.pop();
//        System.out.println(stack.peek());

        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
    class Stack {

        private int[] stackArray;
        //    容量，初始容量为16
        private int capacity = 16;
        private int size = 0;
        //    栈的头部指针
        private int top = -1;
        public Stack() {
            stackArray = new int[this.capacity];
        }

        public Stack(int capacity) {
            this.capacity = capacity;
            stackArray = new int[this.capacity];
        }

        public void push(int x){
            if(isFull()){
                throw new RuntimeException("stack is full!");
            }else{
                this.stackArray[++this.top] = x;
                this.size++;
            }

        }

        public int pop(){
            if(isEmpty()){
                throw new RuntimeException("stack is empty!");
            }else{
                int i = this.stackArray[this.top--];
                this.size--;
                return i;
            }
        }

        public int peek(){
            if(isEmpty()){
                throw new RuntimeException("stack is empty!");
            }else{
                return this.stackArray[this.top];
            }
        }

        public boolean isEmpty(){
            return this.size == 0;
        }

        public int size(){
            return this.size;
        }

        public boolean isFull(){
            return this.size == this.capacity;
        }

        public void clear(){
            this.top = -1;
            this.size = 0;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
