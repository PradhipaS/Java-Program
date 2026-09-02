// 2. Maximum XOR Value
// Problem Statement
// An array contains N elements, where N is even. You can choose at most N/2 numbers from the array.

// Find the maximum possible XOR value obtained from the selected elements.

// Example
// Input

// 4
// 1 2 3 4
// Output

// 7
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Infosys4 {
    private static int maxXorResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Sort descending to process larger numbers first. 
        // This helps maximize high-order bit changes early in the recursion.
        Arrays.sort(a, Collections.reverseOrder());

        int maxSubsetSize = n / 2;
        maxXorResult = 0;

        // Start backtracking: array, current index, selected count, current xor value, max subset limit
        findMaxXor(a, 0, 0, 0, maxSubsetSize);

        System.out.println(maxXorResult);
    }

    private static void findMaxXor(Integer[] a, int index, int count, int currentXor, int maxSubsetSize) {
        // Update global max with our current path result
        if (currentXor > maxXorResult) {
            maxXorResult = currentXor;
        }

        // Base Case: If we reached the maximum allowed elements or the end of the array
        if (count == maxSubsetSize || index == a.length) {
            return;
        }

        // OPTIMIZATION (Pruning): If the best possible XOR we could ever achieve by 
        // combinations with the remaining elements cannot beat our global max, stop.
        int remainingMaxPossible = currentXor;
        for (int i = index; i < a.length; i++) {
            remainingMaxPossible |= a[i];
        }
        if (remainingMaxPossible <= maxXorResult) {
            return;
        }

        // Choice 1: Include the current element in our XOR subset
        findMaxXor(a, index + 1, count + 1, currentXor ^ a[index], maxSubsetSize);

        // Choice 2: Exclude the current element from our XOR subset
        findMaxXor(a, index + 1, count, currentXor, maxSubsetSize);
    }
}
