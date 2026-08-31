import java.util.*;
public class P3{
    public static void main(String[] args) 
        {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int[] arr=new int[n];
            //clockwise
            int max=0;
            for (int i=0;i<n;i++)
            {
               arr[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++){
                 int[] res= new int[n];
                 for(int j=0;j<n;j++)
                 {
                    res[j]=arr[(i+j)%n];
                 }
                 int ans=0;
                 int val=0;
                 for(int a:res)
                 {
                    ans=ans^a;
                    val=val+ans;
                 }
                 max=Math.max(max,val);
            }
             for(int i=0;i<n;i++){
                 int[] res= new int[n];
               for(int k=0;k<n;k++)
               { 
                res[k]=arr[(i-k+n)%n];
               }
                int ans=0;
                 int val=0;
                 for(int a:res)
                 {
                    ans=ans^a;
                    val=val+ans;
                 }
                 max=Math.max(max,val);
            }
            //anticlock
            System.out.println(max);
                
            }
        }
    