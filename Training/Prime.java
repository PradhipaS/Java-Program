import java.util.*;
public class Prime{
    public  static boolean isprime(int n){
        if(n<=1)
        return false;
        if(n==2)
        {
            return true;
        }
        if(n%2==0)
        {
            return false;
        }
        for(int i=3;i*i<=n;i=i+2){
            if(n%i==0)
            {
                return false;
            }
        }
            return true;
        
    }
    static int[] range(int start,int end){
        if (start > end) {
    System.out.println("Invalid range");

}


        int []temp=new int[end-start + 1];
        int  ind=0;
        for(int i=start;i<=end;i++)
        {
            if(isprime(i))
            {
                temp[ind++]=i;
            }
        }
        int[]result=new int[ind];
       System.arraycopy(temp,0,result,0,ind);
       return result;
    }
    
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int start=s.nextInt();
        int end=s.nextInt();
        int []range1=range(start,end);
        for(int i=0;i<range1.length;i++)
        {
            System.out.print(range1[i]+" ");
        }
        s.close();
        }
    }
