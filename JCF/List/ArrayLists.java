package JCF.List;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

// ArrayList is a dynamic array that can grow and shrink automatically as elements are added or removed.
// An ArrayList is a resizable implementation of the List interface.

public class ArrayLists {

    static class Student{
        int id;
        String name;

        Student(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("jam");
        names.add("sam");
        names.add("jam");

        System.out.println(names);

        // Features:
        // odered collection, allows duplicate, allows null values, dynamic size, Fast Random Access[o(1)]

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2); // duplicate
        list.add(null); // null value
        System.out.println(list); // 1,2,3,2 -> odered collection
        System.out.println(list.get(3)); // Access by index is very fast because internally ArrayList uses an array.

        // Internal Working of ArrayList:
        // Internally ArrayList stores data in an array.

        // Capacity vs Size:
        // Size: Number of actual elements. Capacity: Total storage available internally.
        // Java may allocate more memory than currently needed.

        // Default constructor:
        // ArrayList<String> list = new ArrayList<>();

        // Initial capacity:
        // ArrayList<String> list = new ArrayList<>(50);

        // From another collection:
        List<String> names1 = List.of("A","B","C");
        ArrayList<String> list2 = new ArrayList<>(names1);
        System.out.println(list2);

        ArrayList<String> listNames = new ArrayList<>();

        // adding elements:
        listNames.add("jam");
        listNames.add("fam");
        listNames.add("tam");
        listNames.add(0, "Don"); // add(index, element)
        listNames.addAll(names); // addAll()

        // Retrieving Elements
        String value = listNames.get(3);
        System.out.println(value);

        // Updating Elements
        listNames.set(2, "harami");

        // Removing Elements
        listNames.remove(1); // 1 -> index

        // remove(object)
        listNames.remove("harami");
        listNames.clear(); // removes all

        // Searching Elements
        listNames.contains("fam"); // returns boolean value
        listNames.indexOf("jam"); // returns index
        listNames.lastIndexOf("jam"); // return index of last occurance of jam

        // Traversing ArrayList
        // using for loop
        for (int i = 0; i < listNames.size(); i++) {
            System.out.println(listNames.get(i));
        }

        // using enhanced for loop
        for (String name : listNames) {
            System.out.println(name);
        }

        // using iterator: Supports forward and backward traversal.
        ListIterator<String> itr = listNames.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Sorting ArrayList
        Collections.sort(listNames);    // assending order
        Collections.sort(listNames, Collections.reverseOrder()); // desending order

        // ArrayList with Custom Objects
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "sam"));
        students.add(new Student(2, "jam"));

        for(Student s : students) {
            System.out.println(s.id + " " + s.name);
        }

        // Conversion
        // ArrayList to array
        String[] arr = listNames.toArray(new String[0]);
        System.out.println(arr);

        // array to ArrayList
        String[] arr1 = {"A","B","C"};
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(arr1));
        System.out.println(list1);

        // Capacity Management
        list.ensureCapacity(100); // pre-allocates memory
        list.trimToSize(); // removes unused capacity

        // | Operation     | Complexity     |
        // | ------------- | -------------- |
        // | get()         | O(1)           |
        // | set()         | O(1)           |
        // | add() at end  | O(1) amortized |
        // | add(index)    | O(n)           |
        // | remove(index) | O(n)           |
        // | contains()    | O(n)           |
        // | indexOf()     | O(n)           |
        // | iteration     | O(n)           |

        // How resizing works
        // Initial capacity - 10
        // After adding 11th element: Java creates a larger array.
        // using formula : newCapacity = oldCapacity + (oldCapacity >> 1) // (oldCapacity >> 1) -> right shift by 1

        // Fail-Fast Behavior
        // ArrayList<String> list = new ArrayList<>();
        // list.add("A");
        // list.add("B");
        // for(String s : list) {
        //     list.remove(s);
        // }
        // The above code gives error: ConcurrentModificationException -> means a collection was modified while it was being iterated over

        // Use Iterator removal instead:
        ListIterator<String> itr2 = listNames.listIterator();

        while(itr2.hasNext()) {
            if(itr2.next().equals("A")) {
                itr2.remove();
            }
        }

        // Thread Safety: ArrayList is not synchronized.
        // "ArrayList is not synchronized", means that Java does not automatically protect an ArrayList 
        // from being accessed by multiple threads at the same time.
        // A thread is an independent path of execution within a program.
        // Thread safe: A class is thread-safe if multiple threads can use it at the same time without 
        // causing data corruption or unexpected behavior.
        // Synchronization means only one thread can execute a critical section of code at a time.
        // Solutions:
        List<Integer> listP = Collections.synchronizedList(new ArrayList<>());
        System.out.println(listP);
        CopyOnWriteArrayList<Integer> listQ = new CopyOnWriteArrayList<>();
        System.out.println(listQ);

        // | Feature                      | Array | ArrayList            |
        // | ---------------------------- | ----- | -------------------- |
        // | Size                         | Fixed | Dynamic              |
        // | Primitive support            | Yes   | No (Wrapper classes) |
        // | Methods                      | Few   | Many                 |
        // | Resize                       | No    | Yes                  |
        // | Part of Collection Framework | No    | Yes                  |

        // | Feature            | ArrayList     | LinkedList         |
        // | ------------------ | ------------- | ------------------ |
        // | Internal Structure | Dynamic Array | Doubly Linked List |
        // | Random Access      | Fast O(1)     | Slow O(n)          |
        // | Insert Middle      | Slow O(n)     | Faster             |
        // | Delete Middle      | Slow O(n)     | Faster             |
        // | Memory Usage       | Less          | More               |

        // Use ArrayList when:
        // Frequent reading/access, Searching by index, Mostly insertions at end
        // Use LinkedList when:
        // Frequent insertions/deletions in middle

        // Why is ArrayList faster than LinkedList for retrieval?
        // uses index to access O(1)
        // Why insertion in middle is costly?
        // Elements must be shifted. Shifting takes O(n).
        // Can ArrayList store primitives?
        // Directly no

    }

    // Summary

    // ArrayList is:
    // Dynamic array implementation of List
    // Maintains insertion order
    // Allows duplicates and nulls
    // Fast random access (O(1))
    // Slow middle insertion/deletion (O(n))
    // Not thread-safe
    // Most commonly used collection in Java applications

    // For interviews, focus on:
    // Internal dynamic array structure
    // Capacity vs Size
    // Resizing mechanism (1.5x growth)
    // Time complexities
    // ArrayList vs LinkedList
    // Fail-fast behavior
    // Thread-safety considerations
}
