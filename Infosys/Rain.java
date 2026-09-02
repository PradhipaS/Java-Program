// Problem: Given an elevation map represented by an array, compute how much water it can trap after raining.

// Example:

// python

// Copy
// Input:  [,1,,2,1,,1,3,2,1,2,1]
// Output: 6
import java.util.*;
public class Rain{
    public static void main(String[] args) 
        {
            Scanner sc= new Scanner(System.in);
            int n=sc.nextInt();
            int rain[]=new int[n];
            for(int i=0;i<n;i++){
            rain[i]=sc.nextInt();
            }
            int[] left=new int[n];
            int[] right=new int[n];
            int total=0;
            left[0]=rain[0];
            for (int i = 1; i < n; i++) {
                left[i]=Math.max(left[i-1],rain[i]);
                
            }
            right[n-1]=rain[n-1];
            for(int j=n-2;j>=0;j--)
            {
                right[j]=Math.max(right[j+1],rain[j]);
            }
            for(int i=0;i<n;i++)
            {
                total=total+Math.min(left[i],right[i])-rain[i];
            }
System.out.println(total);
        }

    }
