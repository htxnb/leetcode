package leetcode.stack;

import java.util.ArrayList;

/**
 * 问题描述:
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @ClassName MinStack
 * @Author htx
 * @Date 2018/10/8 14:31
 * @Version 1.0
 **/
public class MinStack {
    private int[] stackArray;
    private int[] minStack;
    private int capacity = 2;
    private int top = -1;
    private int size = 0;
    /** initialize your data structure here. */
    public MinStack() {
        this.stackArray = new int[this.capacity];
        this.minStack = new int[this.capacity];
    }

    public MinStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[this.capacity];
        this.minStack = new int[this.capacity];
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    public void push(int x) {
        if(this.size == this.capacity-1){
            grow();
        }
        this.stackArray[++this.top] = x;
        if(isEmpty()){
            this.minStack[this.top] = x;
        }else{
            this.minStack[this.top] = x < this.minStack[this.top-1] ? x :this.minStack[this.top-1];
        }
        this.size++;
    }

    private void grow() {
        int[] temp_stack = new int[this.capacity * 2];
        int[] temp_minStack = new int[this.capacity * 2];
        for (int i = 0; i < this.stackArray.length; i++) {
            temp_stack[i] = this.stackArray[i];
        }
        for (int i = 0; i < this.minStack.length; i++) {
            temp_minStack[i] = this.minStack[i];
        }
        this.minStack = temp_minStack;
        this.stackArray = temp_stack;
        this.capacity *= 2;
    }

    public void pop() {
        if(isEmpty()){
            throw new RuntimeException("stack is empty!");
        }else{
            this.size--;
            this.top--;
        }
    }

    public int top() {
        if(isEmpty()){
            throw new RuntimeException("stack is empty!");
        }else{
            return this.stackArray[this.top];
        }
    }

    public int getMin() {
        return this.minStack[this.top];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

