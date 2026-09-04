
// Problem Statement :

// Given an array A of N elements. You should choose a value B such that (B>=0), and then for each element in A set A[i]=A[i](+)B where is the bitwise XOR.
// Print the minimum number of inversions in array A that you can achieve after choosing the value of B optimally and setting A[i] = A[i] (+) B. Since the answer might be large, print it modulo (10^9+7)

// Input Format

// The first line contains an integer, N. denoting the number of elements in A
// Then the next line contains N elements, denoting the elements in A.
// Input :

// 4
// 1 0 3 2

// Output
// // 1


import java.util.*;

public class Inverse
 {

    static final int MAX_BIT = 30;
    static final long MOD = 1_000_000_007L;

    static class Node {
        Node[] child = new Node[2];
        long count;
    }

    static Node root = new Node();

    // cnt[bit][0] -> inversions when B's bit = 0
    // cnt[bit][1] -> inversions when B's bit = 1
    static long[][] cnt = new long[MAX_BIT + 1][2];

    static void insert(int x) {
        Node cur = root;

        for (int bit = MAX_BIT; bit >= 0; bit--) {
            int b = (x >> bit) & 1;

            if (cur.child[b] == null) {
                cur.child[b] = new Node();
            }

            cur = cur.child[b];
            cur.count++;
        }
    }

    static void query(int x) {
        Node cur = root;

        for (int bit = MAX_BIT; bit >= 0; bit--) {

            if (cur == null) {
                return;
            }

            int b = (x >> bit) & 1;

            // Numbers having the opposite bit here
            // differ from x at the highest differing bit.
            if (cur.child[1 - b] != null) {

                long oppositeCount = cur.child[1 - b].count;

                if (b == 0) {
                    /*
                     * Previous number has 1
                     * Current number has 0
                     *
                     * This is an inversion when B bit = 0.
                     */
                    cnt[bit][0] += oppositeCount;
                } else {
                    /*
                     * Previous number has 0
                     * Current number has 1
                     *
                     * This becomes an inversion when B bit = 1.
                     */
                    cnt[bit][1] += oppositeCount;
                }
            }

            // Continue only with numbers having the same bit.
            cur = cur.child[b];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        /*
         * Process elements from left to right.
         *
         * Trie contains only previous elements,
         * so every pair is considered exactly once.
         */
        for (int i = 0; i < N; i++) {
            query(A[i]);
            insert(A[i]);
        }

        long answer = 0;

        for (int bit = 0; bit <= MAX_BIT; bit++) {
            answer += Math.min(cnt[bit][0], cnt[bit][1]);
            answer %= MOD;
        }

        System.out.println(answer);
    }
}