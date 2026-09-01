
public class Long {
    public static int get_ans(int N, int M, int[] A) {
        // dp[xor][last] = max length subsequence
        int[][] dp = new int[512][N+1]; // XOR up to 500, safe bound 512
        int ans = 0;

        for (int x : A) {
            int[][] newDp = new int[512][N+1];
            for (int xor = 0; xor < 512; xor++) {
                for (int last = 1; last <= N; last++) {
                    if (dp[xor][last] > 0) {
                        // extend subsequence if non-decreasing
                        if (last <= x) {
                            int newXor = xor ^ x;
                            newDp[newXor][x] = Math.max(newDp[newXor][x], dp[xor][last] + 1);
                        }
                        // keep old state
                        newDp[xor][last] = Math.max(newDp[xor][last], dp[xor][last]);
                    }
                }
            }
            // start new subsequence with single element
            newDp[x][x] = Math.max(newDp[x][x], 1);
            dp = newDp;
        }

        // find max length with xor >= M
        for (int xor = M; xor < 512; xor++) {
            for (int last = 1; last <= N; last++) {
                ans = Math.max(ans, dp[xor][last]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 4, M = 3;
        int[] A = {1, 2, 3, 4};
        System.out.println(get_ans(N, M, A)); // Output: 4
    }
}
