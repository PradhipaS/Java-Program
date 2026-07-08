import java.util.*;

class Solution {
    static final long MOD = 1000000007;

    static long getVal(int N, int[] A) {
        long gcdValue = A[0];
        long product = 1;

        // Compute GCD of the array
        for (int i = 1; i < N; i++) {
            gcdValue = gcd(gcdValue, A[i]);
        }

        // Compute product modulo MOD
        for (int i = 0; i < N; i++) {
            product = (product * A[i]) % MOD;
        }

        // Return (product ^ gcdValue) % MOD
        return power(product, gcdValue, MOD);
    }

    // Modular Exponentiation
    static long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }

    // Euclidean algorithm
    static long gcd(long a, long b) {
        return (a == 0) ? b : gcd(b % a, a);
    }

    // Sample main for testing
    public static void main(String[] args) {
        int[] A = {2, 4, 6};
        int N = A.length;
        System.out.println(getVal(N, A));  // Output: 2304
    }
}
