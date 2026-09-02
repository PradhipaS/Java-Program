// Problem: Rotate an array of n elements to the right by k steps.
// Input:  [1, 2, 3, 4, 5, 6, 7], k = 3
// Output: [5, 6, 7, 1, 2, 3, 4]
import java.util.*;
public class Rotate{
    public static void main(String[] agrs)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];

        for(int i=0;i<n;i++){
a[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        rotate(a,k,n);
        System.out.println(Arrays.toString(a));
    }
    public static void rotate(int[] a,int k,int n)
    {
        k=k%n;
        reverse(a,0,n-1);
        reverse(a,0,k-1);
        reverse(a,k,n-1);
    }
    public static void reverse(int[] a,int start,int end)
    {
        while(start<end)
        {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;        }
    }
}