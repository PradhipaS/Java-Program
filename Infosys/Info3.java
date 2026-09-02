// // Problem 1: Subset Sum Problem
// // Problem Statement:
// // Given a set of non-negative integers and a target sum, determine if there is a subset of the given set whose sum is equal to the target sum.

// // Input: A set of integers (e.g., {3, 34, 4, 12, 5, 2}) and a target sum (e.g., 9).
// // Output: True if there is a subset whose sum equals the target, otherwise False.

 import java.util.*;
 public class Info3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int num[]= new int[a];
        for (int i = 0; i < a; i++) {
            num[i]=sc.nextInt();
        }
        int Target=sc.nextInt();
        System.out.println ( sub(num,a,Target) ? "True":"False");
    }
    public static boolean sub(int[] num,int n,int t)
    {
        boolean[] dp=new boolean[t+1];
        dp[0]=true;
        for(int s:num)
        {
            for(int j=t;j>=s;j--)
            {
                if(dp[j-s])
                {
                    dp[j]=true;
                }
            }
        }
        return dp[t];
    }
 }










