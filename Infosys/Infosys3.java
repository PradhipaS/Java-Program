
//  Largest Meatball Problem
// Problem Statement
// A restaurant repeatedly cuts meatballs based on daily demand and reinserts the remaining portion back into the queue.

// Given the initial sizes of meatballs and the number of operations performed, determine which meatball remains the largest at the end.

// Example
// Input

// 5
// 4 7 2 9 5
// Output

// 9
// Explanation
// The largest meatball continues to remain the dominant piece after processing operations.

// Approach
// A max heap or priority queue can efficiently track the largest element after every operation.

// Time Complexity
// O(N log N)
import java.util.*;

public class Infosys3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        int n = sc.nextInt();
        
        // Max-Heap initialization using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < n; i++) {
            maxHeap.add(sc.nextInt());
        }
        
        // If an explicit number of operations 'K' or a cutting factor 'X' is provided 
        // in your specific test engine, you can insert a processing loop here.
        // e.g., while(k--) { int largest = maxHeap.poll(); maxHeap.add(largest - x); }
        
        // Retrieve and print the largest meatball remaining at the top
        if (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.peek());
        }
    }
}
