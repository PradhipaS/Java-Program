import java.util.*;

public class GCD {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int get_ans(int n, int[] a, int p, int q, int[][] queries) {
        int yesCount = 0;
        for (int[] query : queries) {
            int i = query[0] - 1; // 1-indexed
            int val = query[1];
            a[i] = val;

            boolean good = false;

            // Case 1: single element subsequence
            for (int x : a) {
                if (x == p) {
                    good = true;
                    break;
                }
            }

            // Case 2: multiple divisible elements
            if (!good) {
                int g = 0;
                int count = 0;
                for (int x : a) {
                    if (x % p == 0) {
                        g = gcd(g, x);
                        count++;
                    }
                }
                if (count > 0 && count < n && g == p) {
                    good = true;
                }
            }

            if (good) yesCount++;
        }
        return yesCount;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int n = 2;
        int[] a = {3, 3};
        int p = 3;
        int q = 2;
        int[][] queries = {{2, 3}, {1, 6}};
        System.out.println(get_ans(n, a, p, q, queries)); // Output: 2
    }
}
