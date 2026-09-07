import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Four {
    public static void main(String[] args) {
        
    }

    public static int[] smallestAndLargestFromArray(int[] arr){  // Smallest and largest element in an array
        int smallest = arr[0];
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return new int[]{smallest, largest};
    }

    public static int[] reverseAnArray(int[] arr){   // Reverse an Array: using two pointers
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }

    public static int[] reverseAnArray2(int[] arr){  // Reverse an array using for loop and temp array
        int[] tempArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tempArr[tempArr.length - 1 - i] = arr[i];
        }

        return tempArr;
    }

    public static Set<Integer> findDuplicate(int[] arr){  // Finding duplicate elements in an array

        Set<Integer> seen = new HashSet<>();   // To keep track of nums encountered so far
        Set<Integer> dup = new HashSet<>();    // To keep track of duplicate elements

        for (int i = 0; i < arr.length; i++) { // seen.add(arr[i]) returns true if element gets added into the hastset
            if (!seen.add(arr[i])) {           // if element already exists seen.add(arr[i]) returns false
                dup.add(arr[i]);               // adds duplicates elements into the set
            }
        }

        // System.out.println(dup);
        return dup;
    }

    public static int secondLargest(int[] arr){  // To find second largest element in an array
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    public static int secondLargest2(int[] arr){  // To find second largest element in an array

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

}




