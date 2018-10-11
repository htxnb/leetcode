package leetcode.stack;

import java.util.LinkedList;

/**
 * 问题描述：
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * @ClassName ImplementStackUsingQueues
 * @Author htx
 * @Date 2018/10/7 22:04
 * @Version 1.0
 **/
public class ImplementStackUsingQueues {
//    用于添加元素，弹出元素，然后和另一个备用队列交换引用
    private LinkedList<Integer> usingQueue;
//    备用队列
    private LinkedList<Integer> spareQueue;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        usingQueue = new LinkedList<Integer>();
        spareQueue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        usingQueue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(usingQueue.size() == 0){
            throw new RuntimeException("stack is null");
        }else{
            int size = usingQueue.size();
            for (int i = 0; i < size-1; i++) {
                spareQueue.add(usingQueue.poll());
            }
            Integer topElement = usingQueue.poll();
            LinkedList<Integer> temp = spareQueue;
            spareQueue = usingQueue;
            usingQueue = temp;
            return topElement;
        }

    }

    /** Get the top element. */
    public int top() {
        int size = usingQueue.size();
        for (int i = 0; i < size-1; i++) {
            spareQueue.add(usingQueue.poll());
        }
        Integer topElement = usingQueue.peek();
        spareQueue.add(usingQueue.poll());
        LinkedList<Integer> temp = spareQueue;
        spareQueue = usingQueue;
        usingQueue = temp;
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return usingQueue.size() == 0;
    }


    public static void main(String[] args) {
        ImplementStackUsingQueues implementStackUsingQueues = new ImplementStackUsingQueues();
        implementStackUsingQueues.push(1);
        implementStackUsingQueues.push(2);
        implementStackUsingQueues.push(3);
        System.out.println(implementStackUsingQueues.pop());
        System.out.println(implementStackUsingQueues.pop());
        System.out.println(implementStackUsingQueues.pop());
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
