// . Coin Change Problem (Minimum Coins)

// Problem: Given coin denominations and a target amount, find the minimum number of coins needed to make the amount. Return -1 if not possible.

// Example:

// Input:  coins = [1, 5, 6, 9], amount = 11
// Output: 2
// // Explanation: 5 + 6 = 11
import java.util.*;
public class Coin{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] coin=new int[n];
for(int i=0;i<n;i++)
{
    coin[i]=sc.nextInt();
}
int amount=sc.nextInt();

int dp[]= new int[amount+1];
Arrays.fill(dp,amount+1);
dp[0]=0;
for(int i=1;i<=amount;i++)
{
for(int c:coin)
{
    if(i-c>=0)
    {
        dp[i]=Math.min(dp[i],1+dp[i-c]);


}
}
}
System.out.println(dp[amount]>amount?-1:dp[amount]);
    }
}