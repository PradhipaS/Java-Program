//xPattern
import java.util.*;
public class Main{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {   if(i==j)
                System.out.print("*");
                else if(j==n+1-i)
                {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
            
                }
            }
             System.out.println(" ");
            
        }
    }
}
//z pattern
import java.util.*;
public class Main{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {   if(i==1||i==n||i+j==n+1)
            System.out.print("&");
             else
             {
              System.out.print(" ");   
             }
            }
           
             System.out.println(" ");
            
        }
    }
}


//y pattern
import java.util.*;
public class Main{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {   if(i==j&&(i<=n/2+1))
                System.out.print("*");
                else if(j==n+1-i)
                {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
            
                }
            }
             System.out.println(" ");
            
        }
    }
}

//c pattern
import java.util.*;
public class Main{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {   if(i==1||j==1||i==n)
                System.out.print("*");
               
                else{
                    System.out.print(" ");
            
                }
            }
             System.out.println(" ");
            
        }
    }
}


