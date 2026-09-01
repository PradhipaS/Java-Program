import java.util.*;

public class TBP {

    static final long MOD = 1_000_000_007L;

    static List<Integer>[] tree;
    static int[] value;

    // Converts a number into its square-free representation.
    // Example:
    // 12 = 2^2 * 3  -> 3
    // 27 = 3^3      -> 3
    static long getKey(int x) {

        long key = 1;

        for (int p = 2; p * p <= x; p++) {

            int count = 0;

            while (x % p == 0) {
                x /= p;
                count++;
            }

            // Keep prime only when its exponent is odd
            if (count % 2 == 1) {
                key *= p;
            }
        }

        // Remaining prime factor
        if (x > 1) {
            key *= x;
        }

        return key;
    }

    // Stores information about one subtree
    static class Data {

        // square-free key -> frequency
        HashMap<Long, Integer> freq = new HashMap<>();

        // Number of good pairs in this subtree
        long beauty = 0;
    }

    static Data dfs(int node) {

        Data current = new Data();

        // Add current node
        long key = getKey(value[node]);

        current.freq.put(key, 1);

        // Process children
        for (int child : tree[node]) {

            Data childData = dfs(child);

            /*
             * Small-to-large:
             * Always keep the larger HashMap as current.
             */
            if (current.freq.size() < childData.freq.size()) {

                HashMap<Long, Integer> temp =
                        current.freq;

                current.freq =
                        childData.freq;

                childData.freq =
                        temp;
            }

            /*
             * Count good pairs between:
             *
             * current subtree
             *       +
             * child subtree
             *
             * Two nodes form a good pair when
             * their square-free keys are equal.
             */
            for (Map.Entry<Long, Integer> entry
                    : childData.freq.entrySet()) {

                long keyValue = entry.getKey();

                int childCount = entry.getValue();

                int currentCount =
                        current.freq.getOrDefault(
                                keyValue, 0
                        );

                // Number of new pairs
                current.beauty +=
                        (long) currentCount * childCount;
            }

            /*
             * Merge child frequencies
             * into current frequencies.
             */
            for (Map.Entry<Long, Integer> entry
                    : childData.freq.entrySet()) {

                long keyValue = entry.getKey();

                int count = entry.getValue();

                current.freq.put(
                        keyValue,
                        current.freq.getOrDefault(
                                keyValue, 0
                        ) + count
                );
            }

            // Add beauty already calculated
            // inside child's subtree.
            current.beauty += childData.beauty;
        }

        return current;
    }

    public static long get_ans(
            int n,
            int[] par,
            int[] a) {

        value = a;

        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        /*
         * PDF uses:
         *
         * par[1] = 0
         *
         * So here we assume:
         * par[i] contains a 1-based parent
         * for node i+1.
         */
        for (int i = 1; i < n; i++) {

            int parent = par[i] - 1;

            tree[parent].add(i);
        }

        Data result = dfs(0);

        return result.beauty % MOD;
    }

    public static void main(String[] args) {

        /*
         * Sample 1 from the question:
         *
         * n = 5
         *
         * parent:
         * 0
         * 1
         * 1
         * 2
         * 2
         *
         * values:
         * 2
         * 3
         * 6
         * 12
         * 27
         *
         * Expected answer = 6
         */

        int n = 5;

        int[] par = {
                0,
                1,
                1,
                2,
                2
        };

        int[] a = {
                2,
                3,
                6,
                12,
                27
        };

        System.out.println(
                get_ans(n, par, a)
        );
    }
}