
//  Question 5
//    Problem Statement :

// Andy wants to go on a vacation to de-stress himself. Therefore he decides to take a trip to an island. It is given that he has as many consecutive days as possible to rest, but he can only make one trip to the island. Suppose that the days are numbered from 1 to N. Andy has M obligations in his schedule, which     he has already undertaken and which correspond to some specific days. This means that ith obligation is scheduled for day Di. Andy is willing to cancel at most k of his obligations in order to take more holidays.

//     Your task is to find out the maximum days of vacation Andy can take by canceling at most K of his obligations.

//     Input Format

// The first line contains an integer N, denoting the total number of days
// The next line contains an integer M denoting the total number of obligations.
// The next line contains an integer K denoting the largest number of obligations he could cancel 
// Each line i of the M subsequent lines (where 0<=i<=M) contains an integer describing Di.
//     Constraints

// 1<=N<=10^6
// 1<=M<=2*10^6
// 1<=K<=2*10^6
// 1<=D[i]<=10^6
//    Sample Input 1:

//    10
//     5
//     2
//     6
//     9
//      3
//      2
//      7

//    Sample Output 1 :

//     5

//    Explanation:

//     Here he could cancel his 3rd and 4th obligation which makes vacation length 5.

//    Sample input 2:

//     7
//     2
//     0
//     3
//     4

//    Sample Output 2:

//      3

//    Explanation:

//     Here he could not cancel any obligation since K=0, so the vacation length is 3.



import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] D = new int[M];

        for (int i = 0; i < M; i++) {
            D[i] = sc.nextInt();
        }

        Arrays.sort(D);

        int answer = 0;

        /*
         * Vacation before the first obligation.
         */
        answer = Math.max(answer, D[0] - 1);

        /*
         * Vacation after the last obligation.
         */
        answer = Math.max(answer, N - D[M - 1]);

        /*
         * Cancel up to K obligations.
         *
         * If we cancel obligations from i to j,
         * then the vacation is between:
         *
         * D[i-1] and D[j+1]
         */
        for (int i = 0; i < M; i++) {

            int j = Math.min(M - 1, i + K - 1);

            int leftDay;

            if (i == 0) {
                leftDay = 0;
            } else {
                leftDay = D[i - 1];
            }

            int rightDay;

            if (j == M - 1) {
                rightDay = N + 1;
            } else {
                rightDay = D[j + 1];
            }

            int vacation = rightDay - leftDay - 1;

            answer = Math.max(answer, vacation);
        }

        System.out.println(answer);
    }
}