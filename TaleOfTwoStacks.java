import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static class MyQueue<T>{
        Stack<T> stack1, stack2;
        public MyQueue(){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
        
        public void enqueue(T val){
            //while(!stack2.isEmpty())
            //    stack1.push(stack2.pop());
            stack1.push(val);
        }
        
        public void dequeue(){
            if(stack2.isEmpty()){
                while(!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            stack2.pop();
        }
        
        public T peek(){
            if(stack2.isEmpty()){
                while(!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
    
}
