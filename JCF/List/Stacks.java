package JCF.List;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// STACK
// A Stack is a linear data structure that follows the LIFO (Last In, First Out) principle.
// Think of a stack of plates:
// You place a plate on the top.
// You remove a plate from the top.
// The last plate added is the first one removed.

// Basic stack operations
// | Operation | Description                              | Time Complexity |
// | --------- | ---------------------------------------- | --------------- |
// | Push      | Add an element to the top                | O(1)            |
// | Pop       | Remove the top element                   | O(1)            |
// | Peek/Top  | View the top element without removing it | O(1)            |
// | isEmpty   | Check if stack is empty                  | O(1)            |
// | Size      | Number of elements in stack              | O(1)            |


public class Stacks {

    // Implementing Stack using array
    class StackUsingArray{
        int[] arr;
        int top;
        int capacity;

        StackUsingArray(int size){
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        void push(int value){
            if (top == capacity - 1) {
                System.out.println("Stack overflow");
                return;
            }
            arr[++top] = value;
        }

        int pop(){
            if (top == -1) {
                System.out.println("stack underflow");
                return -1;
            }

            return arr[top--];
        }

        int peek(){
            if (top == -1) {
                System.out.println("stack underflow");
                return -1;
            }

            return arr[top];
        }

        boolean isEmpty(){
            return top == -1;
        }
    }

    // Implementing Stack using LinkedList
    class Node{
        int data;
        Node next;

        Node(int date){
            this.data = date;
        }
    }

    class StackUsingLinkedList{
        Node top;

        int push(int value){    // this builds ulata linkedlist
            Node newNode = new Node(value);

            newNode.next = top;
            top = newNode;

            return value;
        }

        int pop(){
            if (top == null) {
                return -1;
            }

            int value = top.data;
            top = top.next;
            return value;
        }

        int peek(){
            return top.data;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); // 1,2,3
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        stack.push(10); // adds an element at top 
        System.out.println(stack.pop());    // removes and returns the element at the top
        System.out.println(stack.peek());   // returns the element at the top
        stack.isEmpty(); // checks is the stack is empty and returns boolean value
        System.out.println(stack.search(2));    // returns position from the top

        // Stack Under the Hood
        // Stack extends Vector.
        // Object->Vector->Stack
        // because of this 
        // Stack is synchronized, Thread-safe, Slightly slower than newer alternatives
        // For modern applications, many developers prefer: Deque, implemented by ArrayDeque
        // Recommended Modern Stack: ArrayDeque, Why?
        // Faster, Not synchronized, Better performance, Recommended by Java documentation

        // EX: ArrayDeque
        Deque<Integer> dequeStack = new ArrayDeque<>();
        dequeStack.push(2);
        dequeStack.push(3);
        dequeStack.push(4);
        System.out.println(dequeStack.pop());
        System.out.println(dequeStack.peek());

        // Implementing Stack using Arrays
        // Implementing Stack using LinkedList

        
        
    }
}
