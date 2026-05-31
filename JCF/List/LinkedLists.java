package JCF.List;

import java.util.ArrayList;
// import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
// import java.util.Queue;
// import java.util.Stack;

// LinkedList is a class in the Java Collections Framework that implements the List, Deque, Queue, 
// and Iterable interfaces. It stores elements as a doubly linked list, where each node contains:
// Data (element), Reference to the previous node, Reference to the next node.

// Internal structure:
// Unlike ArrayList, which stores elements in a dynamic array, LinkedList stores elements in nodes.
// Each node contains
// private static class Node<E> {
//     E item;
//     Node<E> next;
//     Node<E> prev;
// }

public class LinkedLists {
    public static void main(String[] args) {
        // Creating a linked list
        // LinkedList<String> list = new LinkedList<>(); // empty list
        ArrayList<String> names = new ArrayList<>(List.of("name1", "name2"));
        LinkedList<String> namesLL = new LinkedList<>(names);   // with existing collection
        System.out.println(namesLL);

        // Adding elements
        namesLL.add("pagal");
        namesLL.add("chutiya");
        namesLL.add(1, "harami"); // at a specific index

        // getting an element
        String value = namesLL.get(2); 
        System.out.println(value);

        // update an element
        namesLL.set(1, "gotilla");

        // remove element
        namesLL.remove(1);
        namesLL.remove("gotilla"); // by object

        // Special linked list methods
        namesLL.addFirst("lund");   // add at first or begining
        namesLL.addLast("rand");    // add at last or end
        System.out.println(namesLL.getFirst()); // prints 1st element
        System.out.println(namesLL.getLast());  // prints last element
        namesLL.removeFirst();    // removes first node
        namesLL.removeLast();   // removes last node

        // Using Linked List as queue (FIFO)
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("A"); // basically adds
        queue.offer("B");
        queue.offer("C");
        System.out.println(queue.poll());

        // Using LinkedList as Deque
        LinkedList<Integer> deque = new LinkedList<>();
        deque.offerFirst(10);
        deque.offerLast(20);
        deque.offerFirst(5);
        System.out.println(deque);  // [5, 10, 20]

        // Using LinkedList as Stack (LIFO)
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // 3

        // Iterating Through LinkedList
        for (int i = 0; i < namesLL.size(); i++) {  // using simple for loop
            System.out.println(namesLL.get(i));
        }

        for (String name : namesLL) {   // using enchanced for loop
            System.out.println(name);
        }

        ListIterator<String> itr = namesLL.listIterator();  // using iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Important methods
        // | Method        | Description         |
        // | ------------- | ------------------- |
        // | add()         | Add element         |
        // | addFirst()    | Add at beginning    |
        // | addLast()     | Add at end          |
        // | get()         | Get by index        |
        // | getFirst()    | First element       |
        // | getLast()     | Last element        |
        // | remove()      | Remove element      |
        // | removeFirst() | Remove first        |
        // | removeLast()  | Remove last         |
        // | offer()       | Queue insertion     |
        // | poll()        | Queue removal       |
        // | peek()        | Queue head          |
        // | push()        | Stack insertion     |
        // | pop()         | Stack removal       |
        // | contains()    | Check existence     |
        // | clear()       | Remove all elements |
        // | size()        | Number of elements  |

        // Time Complexity
        // | Operation        | LinkedList |
        // | ---------------- | ---------- |
        // | Add First        | O(1)       |
        // | Add Last         | O(1)       |
        // | Remove First     | O(1)       |
        // | Remove Last      | O(1)       |
        // | Access by Index  | O(n)       |
        // | Search           | O(n)       |
        // | Insert in Middle | O(n)       |
        // | Delete in Middle | O(n)       |

        // LinkedList vs ArrayList
        // | Feature             | ArrayList     | LinkedList         |
        // | ------------------- | ------------- | ------------------ |
        // | Internal Structure  | Dynamic Array | Doubly Linked List |
        // | Random Access       | O(1)          | O(n)               |
        // | Insert at Beginning | Slow          | Fast               |
        // | Delete at Beginning | Slow          | Fast               |
        // | Memory Usage        | Less          | More               |
        // | Cache Friendly      | Yes           | No                 |
        // | Traversal Speed     | Faster        | Slower             |

        // Memory Representation
        // Head
        // ↓
        // [prev:null | 10 | next]
        //     ↕
        // [prev | 20 | next]
        //     ↕
        // [prev | 30 | next:null]
        //                     ↑
        //                 Tail
        // Each node stores two references (prev, next), so memory consumption is higher than ArrayList

        // Fail-First error
        // LinkedList<String> list = new LinkedList<>();
        // list.add("A");
        // list.add("B");
        // for (String s : list) {
        //     list.add("C"); // Exception
        // }
        // ConcurrentModificationException
        // Use Iterator.remove() when modifying during iteration.

        // When to Use LinkedList:
        // Use LinkedList when:
        // ✅ Frequent insertions/deletions at beginning or end
        // ✅ Need Queue implementation
        // ✅ Need Deque implementation
        // ✅ Need Stack behavior

        // When not to use:
        // Frequent index-based access, Frequent index-based access, Heavy read operations
        // In all the above cases use arrayList.

        // Interview Question:
        // Is LinkedList synchronized? -> No, not thread safe.
        // Why is LinkedList slow for get(index)?
        // Because it must traverse nodes from the head or tail until the target index is reached.

        // Summary:
        // LinkedList is a doubly linked list implementation in Java.
        // Implements List, Queue, Deque, and can be used as a Stack.
        // Fast insertion and deletion at the ends: O(1).
        // Random access is slow: O(n).
        // Uses more memory than ArrayList.
        // Best for queue/deque operations and frequent insertions/removals.
        // Not ideal for frequent index-based access.

    }
}
