package leetcode.stack;

/**
 * @ClassName BaseballGame
 * @Author htx
 * @Date 2018/10/8 16:44
 * @Version 1.0
 **/
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack stack = new Stack(ops.length);
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
//            筛选出正数和负数
            if(op.charAt(0) >= '0' && op.charAt(0) <= '9' || op.charAt(0) == '-'){
                int opInt = Integer.parseInt(op);
                stack.push(opInt);
                sum += opInt;
            }else if(op.charAt(0) == 'C'){
                int i1 = stack.pop();
                sum -= i1;
            }else if(op.charAt(0) == 'D'){
                int opValue1 = stack.peek();
                stack.push(opValue1*2);
                sum += opValue1*2;
            }else if(op.charAt(0) == '+'){
                int opValue2 = stack.pop();
                int opValue3 = stack.pop();
                int needPush = opValue2+opValue3;
                stack.push(opValue3);
                stack.push(opValue2);
                stack.push(needPush);
                sum += needPush;
            }

        }
        return sum;
    }

    class Stack{
        private int[] stackArray;

        /**
         * 栈顶指针
         */
        private int top = -1;

        private int maxSize = 0;

        private int size = 0;

        public Stack(int maxSize) {
            this.maxSize = maxSize;
            stackArray = new int[maxSize];
        }

        /**
         * T = O(1)
         */
        public void push(int x){
            if(isFull()){
                return;
            }
            stackArray[++this.top] = x;
            this.size++;
        }

        /**
         * 弹出栈顶元素
         * T = O(1)
         * @return
         */
        public int pop(){
            if(isEmpty()){
                throw new RuntimeException("stack is empty!");
            }
            this.size--;
            return stackArray[this.top--];
        }

        /**
         * 访问栈顶元素
         * @return
         */
        public int peek(){
            if(isEmpty()){
                throw new RuntimeException("stack is empty!");
            }
            return stackArray[this.top];
        }
        /**
         * 栈中元素的个数
         * @return
         */
        public int size(){
            return this.size;
        }

        public boolean isEmpty(){
            return size == 0 ? true : false;
        }

        public boolean isFull(){
            return maxSize == size ? true: false;
        }

    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(baseballGame.calPoints(new String[]{"-21","-66","39","+","+"}));
    }
}
