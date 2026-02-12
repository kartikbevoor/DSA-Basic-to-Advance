// In-place reversal logic explanation
// Reversing words in a sentence
// Recursive string reversal

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Six {
    public static void main(String[] args) {
        
    }

    public static String stringReverse(String str){          // Reverse the given string
        StringBuilder sb = new StringBuilder(str).reverse();
        String reverse = sb.toString();
        return reverse;
        // return new StringBuilder(str).reverse().toString();  // the other way
    }

    public static String stringReverse2(String str) {       // Reverse the given string
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }

        return new String(chars);
    }

    public static String stringReverse3(String str){        // Reverse the given string
        String reversed = "";

        for (int i = str.length() - 1; i <= 0; i++) {
            reversed = reversed + str.charAt(i);
        }
        // String reversed = new StringBuilder(str).reverse().toString();
        return reversed;
    }

    public static boolean isStringPallindrome(String str){      // check for pallindrome
        if (str == null) {
            return false;
        }

        String reversed = new StringBuilder(str).reverse().toString();
        if (str.equals(reversed)) {
            return true;
        }

        // return str.equals(reversed) ? true : false;
        return false;
    }

    public static int[] countVowelsAndConsonants(String str) {      // Count vowels and consonants in a string
        if (str == null) {
            return new int[]{-1, -1};
        }

        str = str.toLowerCase();
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        return new int[]{vowelCount, consonantCount};
    }

    public static String removeDuplicateCharectersFromString(String str){  // Remove duplicates from string
        if (str == null) {
            return null;
        }

        Set<Character> set = new LinkedHashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : set) {
            result.append(ch);
        }

        return result.toString();
    }

    public static String removeDuplicates(String str) {     // Remove duplicates from string
        if (str == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (result.indexOf(String.valueOf(ch)) == -1) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static char firstNonRepeatedChar(String str){   // Find the first non-repeated char in an array
        for (int i = 0; i < str.length() - 1; i++) {
            boolean repeated = false;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    repeated = true;
                }
            }
            if (!repeated) {
                return str.charAt(i);
            }
        }

        return ' ';
    }

    public static char firstNonRepeatedChar2(String str) {   // Find the first non-repeated char in an array
        if (str == null || str.length() == 0) {
            return ' ';
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return ' ';
    }

    public static boolean anagramString(String str1, String str2){
        if (str1.length() == 0 || str2.length() == 0) {
            System.out.println("Empty string");
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] x = str1.toLowerCase().toCharArray();
        char[] y = str2.toLowerCase().toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);

        for (int i = 0; i < x.length; i++) {
            if (x[i] != y[i]) {
                return false;
            }
        }

        // this can be used insted of the above for loop
        // return Arrays.equals(x, y);

        // to ignore spaces
        // str1 = str1.replaceAll("\\s+", "");
        // str2 = str2.replaceAll("\\s+", "");

        return true;
    }

    // using sliding window pattern
    public static boolean findSubstringInString(String str1, String str2) {

        if (str2.length() > str1.length()) {
            return false;
        }

        char[] x = str1.toLowerCase().toCharArray();
        char[] y = str2.toLowerCase().toCharArray();

        for (int i = 0; i <= x.length - y.length; i++) {

            int j = 0;

            while (j < y.length && x[i + j] == y[j]) {
                j++;
            }

            if (j == y.length) {
                return true; // full match found
            }
        }
            return false; // no match found
    }

    // the other way
    public static boolean contains(String str, String sub){
        
        for (int i = 0; i + sub.length()< str.length(); i++) {
            int j = 0;
            while (str.charAt(i + j) == sub.charAt(j) && j < sub.length()) {
                j++;
            }
            if (j == sub.length()) {
                return true;
            }
        }
        return false;
    }

}
