// // Next Greater Element

// // Problem: Given an array, for each element return 
// //the first greater element to its right. Return -1 if no such element exists.
// Input:  [1, 3, 2]
// Output: [3, -1, -1]
import java.util.*;
public class Greatest{
    public static void main(String[] args) {
     
        int[] arr = {4, 5, 2, 25};
        System.out.println(Arrays.toString(findNGE(arr))); 
        // Output: [5, 25, 25, -1]
    }
    public static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element exists to the right
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element into the stack
            stack.push(arr[i]);
        }
        return result;
    }

 
}

    }

}