package google;

import java.util.Stack;

/**
 * Created by sumon.chatterjee on 12/12/17.
 */
public class MinStack {

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack= new Stack<Integer>();

        /*public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if(x <= min){
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.
            if(stack.pop() == min) {
                min = stack.pop();
            }
            if (stack.empty()) {
                min = Integer.MAX_VALUE;
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }*/

        void push(int x){
            if(stack.isEmpty() && minStack.isEmpty()){
                minStack.push(x);
            }else{
                if(x < minStack.pop()){
                   minStack.push(x) ;
                }
                stack.push(x);
            }
        }


        void getMin(){
            minStack.pop();
        }


        void pop(){
            if(stack.peek() == minStack.peek()){
                stack.pop();
                minStack.pop();
            }else{
                stack.pop();
            }
        }

    }

