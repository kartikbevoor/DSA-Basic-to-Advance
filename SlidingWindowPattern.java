public class SlidingWindowPattern {
    public static void main(String[] args) {
        
    }

    // sliding window pattern with fixed window size
    // max sum of sub array of size k
    public static int swp(int[] arr, int k){
        int windowSum = 0;
        int start = 0;
        int max = 0;

        for (int end = 0; end < arr.length; end++) {

            windowSum += arr[end];

            if (end >= k - 1) {
                // window size reached k
                max = Math.max(max, windowSum);

                windowSum -= arr[start];
                start++;
            }
        }

        return max;

    }
}

// Max sum of subarray size k
// Find substring of length k
// Average of every subarray size k

// Longest substring without repeating characters
// Smallest subarray with sum >= target
// Longest substring with at most K distinct characters

// Easy:
// Max sum subarray size k
// Contains duplicate II
// Find all anagrams in string
// Medium:
// Longest substring without repeating characters
// Longest repeating character replacement
// Minimum window substring
// Hard:
// Subarrays with K distinct integers
