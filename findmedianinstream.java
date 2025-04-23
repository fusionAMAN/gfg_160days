//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class findmedianinstream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends




class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        
        // brute force:
    //     ArrayList<Double> ans=new ArrayList<>();
    //     ArrayList<Integer>temp=new ArrayList<>();
    //     for(int i=0;i<arr.length;i++){
    //             temp.add(arr[i]);
    //             double x=median(temp);
    //             ans.add(x);
    //     }
    //     return ans;
    // }
    // public double median(List<Integer>arr){
    //   int n= arr.size();
    //     Collections.sort(arr);
    //     if(n%2!=0){
    //         return arr.get(n/2);
    //     }
    //     else{
    //         int x=n/2;
    //         int y=(n/2)-1;
    //         return (arr.get(x)+arr.get(y))/2.0;
            
    //     }
    
    // optimal:
    
    
    
    ArrayList<Double> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min Heap (right half)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap (left half)

        for (int num : arr) {
            addNumber(num, minHeap, maxHeap);
            ans.add(getMedian(minHeap, maxHeap));
        }
        return ans;
    }

    public void addNumber(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.isEmpty() || num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
 
        // **Balance the Heaps**
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek(); // Odd count case
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0; // Even count case
        }
    }

}










