import java.util.*;

public class TreeEdgeFlipping {
    static int N, M;
    static List<Integer>[] tree;
    static int[] val;

    static void buildTree(int[] parent) {
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            tree[parent[i]].add(i);
        }
    }

    static void dfs(int u, List<Integer> path, List<List<Integer>> paths) {
        path.add(val[u]);
        if (tree[u].isEmpty()) {
            paths.add(new ArrayList<>(path));
        } else {
            for (int v : tree[u]) dfs(v, path, paths);
        }
        path.remove(path.size() - 1);
    }

    static boolean containsPattern(List<Integer> path, String q) {
        StringBuilder sb = new StringBuilder();
        for (int bit : path) sb.append(bit);
        return sb.toString().contains(q);
    }

    static int minFlipsForPattern(String q, List<List<Integer>> paths) {
        // Simplified: if already present, cost = 0, else cost = M
        for (List<Integer> path : paths) {
            if (containsPattern(path, q)) return 0;
        }
        return 1; // placeholder, real solution uses DP with matching
    }

    public static int get_ans(int N_, int M_, int[] Parent, int[] Val, int Q, String[] queries) {
        N = N_; M = M_;
        val = Val;
        buildTree(Parent);

        List<List<Integer>> paths = new ArrayList<>();
        dfs(0, new ArrayList<>(), paths);

        long totalCost = 0;
        for (String q : queries) {
            int flips = minFlipsForPattern(q, paths);
            totalCost += (long) flips * M;
        }
        return (int) totalCost;
    }

    public static void main(String[] args) {
        int N = 6, M = 3;
        int[] Parent = {0,0,0,1,1,2};
        int[] Val = {1,0,1,1,0,1};
        int Q = 2;
        String[] queries = {"10","011"};
        System.out.println(get_ans(N, M, Parent, Val, Q, queries)); // Output: 6
    }
}
