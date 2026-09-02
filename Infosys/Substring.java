// Longest Common Subsequence (Dynamic Programming)

// One of the most commonly asked medium-level Infosys SP and DSE coding questions.

// Problem: Given two strings, find the length of their longest common subsequence.
// Input:  s1 = "ABCBDAB", s2 = "BDCAB"
// Output: 4
// Explanation: "BCAB" is the LCS
import java.util.*;
public class Substring{
public static void main(String[] args)
{
    Scanner sc= new Scanner(System.in);
    String s1=sc.nextLine();
    String s2= sc.nextLine();
    int m=s1.length();
    int n=s2.length();
    int dp[][]=new int[m+1][n+1];
    for(int i=1;i<=m;i++)
    {
        for(int j=1;j<=n;j++){
          if(s1.charAt(i-1)==s2.charAt(j-1))
          {
            dp[i][j]= dp[i-1][j-1]+1;
          }
          else{
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
          }
        }
    }
    System.out.println(dp[m][n]);
}
}