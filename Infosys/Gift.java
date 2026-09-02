// 7. Maximize Total Value by Packing Gifts into K Boxes (DP + Sliding Window)

// This is a representative hard-level problem that has appeared in Infosys specialist programmer coding questions.

// Problem: You have N gifts of different types. Pack them into exactly K boxes (consecutive subarrays) such that each box's value equals the number of distinct gift types in it. Maximize total value.

// Input:  N=6, K=3, gifts=[1,1,2,2,3,3]
// Output: 4
// Explanation: [1]=1, [1,2,2]=2, [3,3]=1 → total = 4
// Approach: DP with a sliding window and a HashMap to track distinct elements. dp[i][j] = maximum value of packing the first j gifts into i boxes. Use a two-pointer or sliding window within each DP transition.
import java.util.*;
public class Gift{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int gifts[]=new int[n];
        for(int i=0;i<n;i++){
            gifts[i]=sc.nextInt();
        }
        int dp[][]=new int[k+1][n+1];
        for(int i=1;i<=k;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(j<i)
                {
                    continue;
                }
                int max=0;
                Set<Integer>res= new HashSet<>();
                for(int p=j-1;p>=0;p--)
                {
                    res.add(gifts[p]);
                    if(p>=i-1)
                    {
                        max=Math.max(max,dp[i-1][p]+res.size());
                    }
                }
                dp[i][j]=max;

            }
        }
        System.out.println(dp[k][n]);
    }
}
