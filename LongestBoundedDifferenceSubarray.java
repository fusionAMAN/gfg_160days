import java.util.*;

public class LongestBoundedDifferenceSubarray {
    public static List<Integer> findLongestSubarray(int[] arr, int x) {
        int n = arr.length;
        if (n == 0) return new ArrayList<>();
        
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int start = 0, maxLen = 0, resStart = 0;
        
        for (int end = 0; end < n; end++) {
            // Maintain maxDeque
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[end]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(end);
            
            // Maintain minDeque
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[end]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(end);
            
            // Check if current window is invalid
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                start++;
                // Remove elements out of window
                if (maxDeque.peekFirst() < start) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < start) {
                    minDeque.pollFirst();
                }
            }
            
            // Update longest window if needed
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                resStart = start;
            }
        }
        
        // Prepare result
        List<Integer> result = new ArrayList<>();
        for (int i = resStart; i < resStart + maxLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr1 = {8, 4, 2, 6, 7};
        int x1 = 4;
        System.out.println(findLongestSubarray(arr1, x1));  // Output: [4, 2, 6]

        int[] arr2 = {15, 10, 1, 2, 4, 7, 2};
        int x2 = 5;
        System.out.println(findLongestSubarray(arr2, x2));  // Output: [2, 4, 7, 2]
    }
}
