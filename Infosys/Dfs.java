//  Longest Increasing Path in a Matrix (DFS + Memoization)

// Problem: Given an m x n integer matrix, return the length of the longest increasing path.

// Approach: DFS from each cell with memoization. From each cell, try all 4 directions and move only if the next value is strictly greater.
import java.util.*;
public class Dfs{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        for(int i=0;i<n; i++){
            for(int j=0;j<n;j++)
            {
a[i][j]=sc.nextInt();
        }
        }
        System.out.println(find(a,n));

    }
    private static final int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public static int find(int[][]mat,int n)
    {
       if(n==0 ||mat==null)
       {
        return 0;
       }int[][] m= new int[n][n];
        int max = 0;
       for(int i=0;i<n; i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,Dfs(mat,i,j,n,m));
            }
       
    }
    return max;
    }
    public static int Dfs(int[][] mat,int i,int j,int n,int[][] m)
{
    if(m[i][j]!=0)
    {
        return m[i][j];
    }
    int maxp=1;
    for(int[]d:dir)
    {
        int a=i+d[0];
        int b=j+d[1];
        if(a>=0 && a<n&& b<n&& b>=0 && mat[a][b]>mat[i][j])
        {
            int path=1+Dfs(mat,a,b,n,m);
            maxp=Math.max(maxp,path);
        }

    }
    m[i][j]=maxp;
    return maxp;
}
}