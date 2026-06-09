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
    
    }
}
