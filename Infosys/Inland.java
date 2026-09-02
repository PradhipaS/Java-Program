// Number of Islands (BFS/DFS on Grid)

// Problem: Given a 2D grid of '1's (land) and '0's (water), count the number of islands. An island is formed by connecting adjacent lands horizontally or vertically.

// Input:
// 11110
// 11010
// 11000
// 00000
// Output: 1
import java.util.*;
public class Inland{
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    int [][] grid= new int[n][m];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++){
           grid[i][j]=sc.nextInt();
        }
    }
    System.out.println(ans(grid));
}
public static int ans(int[][] grid)
{
    if(grid==null || grid.length==0)
    {
        return 0;
    }
    int c=0;
    int m=grid.length;
    int n=grid[0].length;
for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++){
            if(grid[i][j]==1)
            {
c++;
dfs(grid,i,j,m,n);
            }
        }}
        return c;
}
public static void dfs(int[][]grid,int r,int col,int m,int n)
{
    if(r<0 ||col<0|| r>=m||col>=n||grid[r][col]==0)
    {
        return ;
    }
    grid[r][col]=0;
    dfs(grid,r-1,col,m,n);
dfs(grid,r+1,col,m,n);
dfs(grid,r,col-1,m,n);
dfs(grid,r,col+1,m,n);
}
}