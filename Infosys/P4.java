import java.util.*;
public class P4
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int a=sc.nextInt();
            res.add(a);
        }
        int ans=0;
        Collections.sort(res);
        while(!res.isEmpty())
        {
            if(!res.get(0).equals(res.get(res.size()-1)))
            {  
                res.remove(res.size()-1);
                if(!res.isEmpty())
                {
                    res.remove(0);
                }
               ans++;
            }
            else{
               res.remove(0);
               ans++; 
            }
        }
        System.out.println(ans);

    }
}