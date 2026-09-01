import java.util.*;
public class TBP {
    static final int MOD = 1000000007;
    static List<Integer>[] tree;
    static int[] a;
    static long ans = 0;

    // Function to compute square-free part of a number
    static int squareFreePart(int x) {
        int res = 1;
        for (int p = 2; p * p <= x; p++) {
            int cnt = 0;
            while (x % p == 0) {
                x /= p;
                cnt++;
            }
            if (cnt % 2 == 1) res *= p; // keep prime if odd exponent
        }
        if (x > 1) res *= x;
        return res;
    }

    // DFS returns frequency map of square-free parts in subtree
    static Map<Integer, Integer> dfs(int u) {
        Map<Integer, Integer> freq = new HashMap<>();
        int sf = squareFreePart(a[u]);
        freq.put(sf, 1);

        for (int v : tree[u]) {
            Map<Integer, Integer> child = dfs(v);
            // Merge smaller map into larger (DSU on tree trick)
            if (child.size() > freq.size()) {
                Map<Integer, Integer> tmp = freq;
                freq = child;
                child = tmp;
            }
            for (var e : child.entrySet()) {
                freq.merge(e.getKey(), e.getValue(), Integer::sum);
            }
        }

        // Count good pairs in this subtree
        long beauty = 0;
        for (int count : freq.values()) {
            beauty += (long) count * (count - 1) / 2;
        }
        ans = (ans + beauty) % MOD;
        return freq;
    }

    public static int get_ans(int n, int[] par, int[] values) {
        a = values;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            tree[par[i] - 1].add(i); // parent is 1-indexed
        }
        dfs(0); // root is node 1 (index 0)
        return (int) ans;
    }

    // Example usage
    public static void main(String[] args) {
        int n = 5;
        int[] par = {0,1,1,2,2};
        int[] values = {2,3,6,12,27};
        System.out.println(get_ans(n, par, values)); // Output: 6
    }
}
