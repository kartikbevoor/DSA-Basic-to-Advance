package JCF.List;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Vector is a legacy class in Java that implements a dynamic array. It is similar to ArrayList, 
// but all its methods are synchronized, making it thread-safe by default.

// Thread Safe:
// All major methods are synchronized.
// This makes Vector safe for multiple threads but slower than ArrayList.

public class Vectors {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(); // default constructor
        vector.add("oye");
        vector.add("duffer");   // dynamic resizing
        
        Vector<Integer> intVector = new Vector<>();
        intVector.add(10);
        intVector.add(20);
        intVector.add(30);
        System.out.println(intVector); // [10, 20, 30] -> maintains insertion order

        vector.add("oye"); // allows duplicate
        vector.add(null);  // allows null value

        // Vector<String> v = new Vector<>(20); // vector with initial capacity
        // Vector<String> v = new Vector<>(10, 5);  // 10 -> initial capacity, 5 -> capacity to increment

        // Creating a vector from collection
        List<String> list = List.of("asdf", "dsfg");
        Vector<String> listVector = new Vector<>(list);
        System.out.println(listVector);

        // Working of vectors:
        // Initailly a vector is created with a capacity of 10 (default capacity)
        // When capacity exceeds the vector doubles its size
        // Size: Number of actual elements.
        // Capacity: Current storage capacity.

        System.out.println(vector.size());
        System.out.println(vector.capacity());

        // Common methods:
        vector.add(null); // add
        vector.add(1, "dont"); // add(index, element)
        String value = vector.get(3); // get
        System.out.println(value);
        vector.set(0, "value"); // set
        vector.remove(0); // remove(index)
        vector.remove("oye"); // remove(obj)
        vector.contains("dufer"); // contains: returns boolean value
        vector.isEmpty(); // isEmpty
        vector.clear(); // clear
        vector.size(); // size
        vector.capacity(); // capacity
        vector.elementAt(3); // elementAt(index)
        vector.firstElement();  // firstElement
        vector.lastElement(); // lastElement
        vector.insertElementAt("chal", 0); // insertElement(value, index)
        vector.removeElement("value"); // removeElement
        vector.removeElementAt(2);  // removeElementAt(index)
        vector.removeAllElements(); // removeAllElements
        vector.setElementAt("tuu", 4); // setElementAt(value, index)
        vector.ensureCapacity(29); // ensureCapacity -> increaces capacity if required
        vector.trimToSize(); // trimToSize -> removes unused capacity

        // Iterating through vectors
        // For loop
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }

        // Enhanced for loop
        for (String v : vector) {
            System.out.println(v);
        }

        // Iterator
        Iterator<String> itr = vector.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Enumeration: Vector introduced Enumeration before Iterator existed.
        Enumeration<String> e = vector.elements();
        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }

        Vector<String> langs = new Vector<>();
        langs.add("java");
        langs.add("python");
        langs.add("golang");

        System.out.println("Vector: " + langs);
        System.out.println("First:" + langs.firstElement());
        System.out.println("Last: " + langs.lastElement());
        langs.remove("python");
        System.out.println(langs);

        // Vector vs ArrayList
        // | Feature             | Vector             | ArrayList        |
        // | ------------------- | ------------------ | ---------------- |
        // | Thread Safe         | Yes                | No               |
        // | Synchronization     | Synchronized       | Not synchronized |
        // | Performance         | Slower             | Faster           |
        // | Capacity Growth     | Doubles by default | 1.5x growth      |
        // | Legacy Class        | Yes                | No               |
        // | Introduced          | JDK 1.0            | JDK 1.2          |
        // | Enumeration Support | Yes                | No               |

        // Vector vs LinkedList
        // | Feature        | Vector        | LinkedList               |
        // | -------------- | ------------- | ------------------------ |
        // | Data Structure | Dynamic Array | Doubly Linked List       |
        // | Random Access  | Fast O(1)     | Slow O(n)                |
        // | Insert Middle  | O(n)          | O(1) after locating node |
        // | Memory Usage   | Lower         | Higher                   |
        // | Cache Friendly | Yes           | No                       |

        // Time Complexity
        // | Operation     | Complexity     |
        // | ------------- | -------------- |
        // | get(index)    | O(1)           |
        // | set(index)    | O(1)           |
        // | add(end)      | O(1) amortized |
        // | add(index)    | O(n)           |
        // | remove(end)   | O(1)           |
        // | remove(index) | O(n)           |
        // | contains()    | O(n)           |
        // | search()      | O(n)           |

        // SYNCHRONIZATION:
        // What Does Synchronization Mean?
        // Synchronization ensures that only one thread can execute a synchronized method on the same object at a time.
        // When a thread accesses a synchronized method of a Vector, it acquires the vector's intrinsic lock (monitor). 
        // Other threads trying to execute synchronized methods on that same vector must wait until the lock is released.
        // whenever a synchronized method execute, it acquires the object's lock before executing.
        // Important Limitation: Compound Operations Are Not Thread-Safe
        // Even though individual methods are synchronized, combinations of operations are not automatically safe.
        // if (!vector.contains("Java")) {
        //     vector.add("Java");
        // }
        // Suppose two threads execute this code simultaneously:
        // Thread A checks contains() → false
        // Thread B checks contains() → false
        // Thread A adds "Java"
        // Thread B adds "Java"
        // result -> [Java, Java]
        // Synchronization protects each method call separately, not the entire sequence.
        // correct approach: 
        // synchronized (vector) {
        //     if (!vector.contains("Java")) {
        //         vector.add("Java");
        //     }
        // }
        // Now the whole block executes atomically.
        // Only one thread can modify the vector at a time.
        // Thread-1 ---> add()
        //      LOCK ACQUIRED
        // Thread-2 ---> add()
        //             WAITING
        // Thread-1 ---> LOCK RELEASED
        // Thread-2 ---> LOCK ACQUIRED
        // Performance impact:
        // synchorization introduces overhead -> lock acquisition -> lock release -> Thread contention
        // for single thread application like ArrayList it is usually faster than vectors because ArrayList has no synchronization overhead.
        // Key Interview Points:
        // Vector is a thread-safe dynamic array.
        // All major methods are synchronized.
        // Synchronization occurs at the method level.
        // Individual operations are thread-safe, but compound operations are not.
        // Iteration requires external synchronization for complete safety.
        // Vector is a legacy collection; modern code often uses:
        // ArrayList
        // Collections.synchronizedList()
        // CopyOnWriteArrayList
        // Due to synchronization overhead, Vector is generally slower than ArrayList.
        // Summary
        // Vector achieves synchronization by making its methods synchronized, ensuring that only one thread can execute 
        // a method on a particular vector instance at a time. This protects individual operations from 
        // concurrent access issues, but multi-step operations and iterations still require additional synchronization. 
        // While Vector remains thread-safe, modern Java applications typically prefer newer concurrent collections 
        // that provide better scalability and performance.

        // THREAD-SAFE:
        // A class is thread-safe if multiple threads can access it simultaneously without corrupting data.
        // The sentence "Vector is a thread-safe dynamic array" is justified because:
        // It behaves like a dynamic array, automatically resizing itself when more elements are added.
        // It is thread-safe because its methods are synchronized, ensuring only one thread can access or modify the Vector at a time.
        // This synchronization prevents data corruption during concurrent access.
        // However, synchronization is at the method level, so compound operations may still require external synchronization.
        // Vector is called a thread-safe dynamic array because it stores elements in a resizable array structure 
        // and protects its operations using synchronization, allowing safe access by multiple threads.

        // FAIL-FIRST BEHAVIOUR:
        // What is ConcurrentModificationException?
        // ConcurrentModificationException occurs when a collection is modified while it is being iterated.
        // Why this happens
        // The enhanced for-loop uses an Iterator internally.
        // for(Integer num : v) this is roughly equilent to 
        // Iterator<Integer> it = v.iterator();
        // while(it.hasNext()) {
        //     Integer num = it.next();
        // }
        // The iterator expects the collection structure to remain unchanged.
        // when we do v.remove(num); -> the collection changes outside the iterator
        // the iterator detects this and throws -> ConcurrentModificationException
        // most java collection maintains something called modcount, when something changes it this is incremented
        // when iterator is created it stores something like expectedModCount = modCount
        // during iteration, it.next(); -> it checks this modcount so when it changes, 
        // if(expectedModCount != modCount)
        // throw new ConcurrentModificationException();
        // it throws -> ConcurrentModificationException
        // This is called a fail-fast iterator.
        // we know vectors are synchornised, but y this error, Even though Vector methods are synchronized
        // v.remove(n); changes modCount
        // The iterator notices the change and fails.
        // So synchronization and fail-fast behavior are different concepts.
        // Correct way to remove during iteration
        // Iterator<Integer> it = v.iterator();
        // while(it.hasNext()) {
        //     Integer n = it.next();

        //     if(n == 2) {
        //         it.remove();
        //     }
        // }
        // Why can ConcurrentModificationException occur with Vector even though Vector is synchronized?
        // Vector synchronizes individual methods such as add(), remove(), and get(), making single operations thread-safe. 
        // However, its iterators are fail-fast. If the collection is structurally modified after the iterator is created 
        // (except through Iterator.remove()), the iterator detects the change through modCount and throws ConcurrentModificationException.
    
    }
}
