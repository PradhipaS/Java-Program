 import java.util.*;
 public class P2{
    public static void main(String[] args) {
        {
            
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int[] arr=new int[n+1];
            arr[0]=0;
            arr[1]=1;
            for(int i=1;i<=n/2;i++)
            {
                arr[2*i]=arr[i];
                if((2*i)+1<=n)
                {
                    arr[(2*i)+1]=arr[i]+arr[i+1];
                }
            }
            int max=arr[0];
            for(int i=1;i<=n;i++)
            {
            if(arr[i]>max)
            {
                max=arr[i];
            }
            }
            System.out.println(max);
        }
    }

 }