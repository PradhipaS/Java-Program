import java.util.*;
public class Problem1 {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        char d=sc.nextLine().charAt(0); 
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==d)
            {
                String temp=s.substring(0,i)+s.substring(i+1);
                int val=Integer.parseInt(temp);
                if(max<val)
                {
                    max=val;
                }

            }
        }
        System.out.println(max);
    }

}