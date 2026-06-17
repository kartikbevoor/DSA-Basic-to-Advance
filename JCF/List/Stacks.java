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

    // Balanced Parentheses Example
    static boolean isBalanced(String str) {

        Stack<Character> stack = new Stack<>(); // Declare a stack of character

        for(char ch : str.toCharArray()) {  // here: the string is converted to charector array
            if(ch == '(' || ch == '{' || ch == '[') { // for opening parenteses push into stack
                stack.push(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']') {  // for closing parenteses check 
                if(stack.isEmpty()){                        // is stack is empty if empty return false
                    return false;
                }
                    
                char top = stack.pop();                     // else: pop the top element and compare with ch
                if((ch == ')' && top != '(') ||
                   (ch == '}' && top != '{') ||
                   (ch == ']' && top != '['))
                    return false;
            }
        }

        return stack.isEmpty(); // finally if stack is empty return true
    }

    public static String reverseString(String str){

        Stack<Character> stack = new Stack<>();

        for (Character ch : str.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reverseString(str);
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

        // Overflow: 
        // Occurs when trying to insert into a full stack.
        // Consider a stack with a capacity of 3 but you try to push 4th element into it 
        // the above condition is known as stack overflow

        // Underflow
        // Occurs when removing from an empty stack.
        // Consider a empty stack and you try to pop an element from the stack 
        // the above condition results to stack underflow.

        // Applications of Stack

        // Function call management:
        // main()
        //     |
        //     --> fun1()
        //                 |
        //                 --> fun2()
        // Execution
        // Push main()
        // Push fun1()
        // Push fun2()
        // Pop fun2()
        // Pop fun1()
        // Pop main()
        // Push -> for function call
        // Pop -> after function finishes its execution

        // Expression Evaluation:
        // Used in: calculators, compilers, interpretors, etc
        // ex: (2 + 3) * 5
        
        // Parentheses Matching:
        // check: ((a+b)*c) true
        // check: ((a+b) false

        // Undo/Redo Operations:
        // Applications: Text editors, IDEs, Graphic software
        // Type A
        // Type B
        // Type C
        // Undo
        // Undo
        // Stack stores previous states.

        // Browser History:
        // Page A
        // Page B
        // Page C
        // Back
        // Uses stack-like behavior.
        // Note: Depth First Search (DFS) is implemented using stack

        // Balanced Parentheses Example
        System.out.println(isBalanced("{[()]}"));

        // Reversing a String
        String reversed = reverseString("Shabash");
        System.out.println(reversed);

        // Interview Questions on Stack
        // Easy
        // What is LIFO?
        // Difference between Stack and Queue?
        // What is push and pop?
        // What is stack overflow?
        // What is stack underflow?

        // Medium
        // Implement stack using array.
        // Implement stack using linked list.
        // Check balanced parentheses.
        // Reverse a string using stack.
        // Sort a stack.

        // Advanced
        // Implement Min Stack in O(1).
        // Implement Stack using Queues.
        // Implement Queue using Stacks.
        // Evaluate postfix expression.
        // Next Greater Element problem.
        // Largest Rectangle in Histogram.
        // Monotonic Stack problems.

        // Stack vs Queue
        // | Feature   | Stack  | Queue       |
        // | --------- | ------ | ----------- |
        // | Principle | LIFO   | FIFO        |
        // | Insert    | Top    | Rear        |
        // | Delete    | Top    | Front       |
        // | Example   | Plates | Ticket line |
        // | DFS/BFS   | DFS    | BFS         |

        // Summary: In Java, a stack is a LIFO data structure used for function calls, expression evaluation, 
        // undo/redo systems, DFS, parsing, and many interview problems. While java.util.Stack still works, 
        // Deque with ArrayDeque is generally the preferred modern implementation for stack behavior.

    }
}
