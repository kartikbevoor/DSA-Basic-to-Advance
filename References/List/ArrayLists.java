package References.List;

import java.util.ArrayList;
import java.util.List;

// ArrayList is a dynamic array that can grow and shrink automatically as elements are added or removed.
// An ArrayList is a resizable implementation of the List interface.

public class ArrayLists {
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
    }


}
