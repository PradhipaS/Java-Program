// A subarray of array A is a segment of contiguous elements in array A.
// Given an array A of N elements, you can apply the following operations as many times as you like:
// – Choosing a subarray [L, R] and subtracting 1 from each element in this subarray. The cost of this operation is X.
// – Choosing an index i such that A[i] is positive, and setting A[i] = 0. The cost of this operation in Y.

// Your task is to make all the elements equal to 0 and find the minimum cost to do so.

// Input Format

// The first line contains an integer, N., denoting the number of elements in A.
// The next line contains an integer, X, denoting the cost of the first operation.
// The next line contains an integer. Y, denoting the cost of the second operation
// Each line i of the N subsequent lines (where 1 <=i<= N) contains an Integer describing Ai.
// Constraints

// 1<=N<=10^5
// 1<=X<=10
// 1<=Y<=10^4
// 1<=A[i]<=10^8
 

// Sample Input 1

// 1
// 1
// 10
// 1

// Sample Output 1

// 1

// Explanation:

// N=1 X=1 Y=10 A=[1]. The optimal solution is to perform one operation of the first type on the subarray [1,N].

// Sample Input 2

// 3
// 1
// 1
// 1
// 1
// 1

// Sample Output 2

// 1

// Explanation:

// N=3 X=1 Y=1 A=[1,1,1] The optimal solution is to perform one operation of the first type on the subarray[1,N];
import java.util.*;

public class File {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long X = sc.nextLong();
        long Y = sc.nextLong();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        /*
         * If range operation is never better than
         * setting elements individually.
         */
        if (X >= Y) {
            System.out.println((long) N * Y);
            return;
        }

        /*
         * Monotonic stack.
         *
         * Each stack element represents a height level.
         */
        long answer = 0;

        // Stack<Integer> stack = new Stack<>();

        // for (int i = 0; i < N; i++) {

        //     while (!stack.isEmpty()
        //             && A[stack.peek()] > A[i]) {

        //         stack.pop();
        //     }

        //     stack.push(i);
        // }

        /*
         * Simple alternative:
         * For each connected height level,
         * compare range operation vs individual operations.
         */

        answer = solve(A, X, Y);

        System.out.println(answer);
    }

    static long solve(int[] A, long X, long Y) {

        int n = A.length;

        long[] dp = new long[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            // Make A[i-1] zero individually
            dp[i] = dp[i - 1] + Y;

            /*
             * Range operation can be beneficial when
             * several consecutive elements are positive.
             */
            long min = A[i - 1];

            for (int j = i - 1; j >= 0; j--) {

                min = Math.min(min, A[j]);

                long rangeCost =
                        min * X + dp[j];

                dp[i] = Math.min(dp[i], rangeCost);

                /*
                 * Once individual operations become
                 * cheaper, no need to continue.
                 */
                if ((long) (i - j) * Y <= min * X) {
                    break;
                }
            }
        }

        return dp[n];
    }
}