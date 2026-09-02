// // Next Greater Element

// // Problem: Given an array, for each element return 
// //the first greater element to its right. Return -1 if no such element exists.
// Input:  [1, 3, 2]
// Output: [3, -1, -1]
import java.util.*;
public class Greatest{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }int [] ans=new int[n];
        Stack <Integer>res= new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
        while(!res.isEmpty() && res.peek()<=arr[i])
            {
                res.pop();
            }
           ans[i]=res.isEmpty()?-1:res.peek();
           res.push(arr[i]);
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(ans[i]+" ");
        }
    }}