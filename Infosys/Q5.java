// 
import java.util.*;
public class Q5{
    public static void main(String[] args) {
        
            Scanner sc= new Scanner(System.in);
            int n=sc.nextInt();
            fib(n);
        
    }
    public static void fib(int n)
    { int a=0,b=1,c=0;
        for(int i=0;i<n;i++)
        {System.out.print(a+" ");
            c=a+b;
            a=b;
            b=c;
        }
        
    }
}