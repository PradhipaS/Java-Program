// 11. Remove Duplicates from Sorted Array
// Problem Statement
// In data cleanup for a sorted list of user IDs, remove duplicates in-place to maintain a unique sequence for database deduplication.

// Sample Input
// 0 0 1 1 2 2 3 4

// Sample Output
// 0 1 2 3 4
import java.util.Scanner;
//import java.util.*;


public class Info1 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[8];
        for (int i = 0; i < 8; i++) {
            nums[i] = scanner.nextInt();
        }
        int n = removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        scanner.close();
    }
}