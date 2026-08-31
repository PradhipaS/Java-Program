import java.util.*;
public class Stringty{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String q=sc.nextLine();
        String [] arr=q.split("\\s+");
        int ans=0;
        for(String i:arr)
        { int a= s.indexOf(i);
            if(a==-1)
ans=ans+0;
else{
    ans=ans+s.length()-a;
}
        }
        System.out.println(ans);
    }
}