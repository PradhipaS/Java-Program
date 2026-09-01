// Problem Statement: Maximum Bounded-Subset XORYou are given an array \(A\) of \(N\) integers. You want to select a non-empty subset of elements from this array such that the size of the chosen subset is at most \(K\), where \(K = \lfloor N / 2 \rfloor\) (if \(N = 1\), then \(K = 1\)).Your task is to find the maximum possible bitwise XOR sum that can be achieved by XORing all the elements of the chosen subset together.Input FormatThe first line contains a single integer \(N\) — the number of elements in the array.The second line contains \(N\) space-separated integers representing the elements of the array \(A\).Output FormatPrint a single integer representing the maximum bitwise XOR sum obtainable under the given constraints.Constraints\(1 \le N \le 100\)\(0 \le A[i] \le 10^6\)Sample Input 1text3
// 1 2 4
// Use code with caution.Sample Output 1text4
// Use code with caution.Explanation 1Here, \(N = 3\), so \(K = \lfloor 3 / 2 \rfloor = 1\).You can pick a subset of at most 1 element. The possible non-empty subsets are \(\{1\}\) (XOR = 1), \(\{2\}\) (XOR = 2), and \(\{4\}\) (XOR = 4).The maximum XOR sum is 4.Sample Input 2text4
// 3 4 5 6
// Use code with caution.Sample Output 2text7
// Use code with caution.Explanation 2Here, \(N = 4\), so \(K = \lfloor 4 / 2 \rfloor = 2\).You can pick a subset of at most 2 elements. Choosing the subset \(\{3, 4\}\) yields a bitwise XOR sum of \(3 \oplus 4 = 7\), which is the maximum possible value.


import java.util.Arrays;
import java.util.Scanner;

public class Xor{
    public static int solve(int N, int[] A) {
        int K = Math.max(1, N / 2);
        int MAX_X = 1 << 20; // 1048576 covers numbers up to 1e6
        int INF = 1000;

        int[] dp = new int[MAX_X];
        int[] ndp = new int[MAX_X];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int a : A) {
            System.arraycopy(dp, 0, ndp, 0, MAX_X);
            for (int x = 0; x < MAX_X; x++) {
                if (dp[x] != INF) {
                    int nx = x ^ a;
                    if (ndp[nx] > dp[x] + 1) {
                        ndp[nx] = dp[x] + 1;
                    }
                }
            }
            int[] tmp = dp; dp = ndp; ndp = tmp;
        }

        for (int x = MAX_X - 1; x >= 0; x--) {
            if (dp[x] <= K && dp[x] > 0) {
                return x;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(solve(N, A));
    }
}
