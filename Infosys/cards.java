import java.util.*;
public class Cards{
public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());
    List<String> res= Arrays.asList(sc.nextLine().split(" "));
    int s=Integer.parseInt(sc.nextLine());
    String target=sc.nextLine();
    System.out.println(cards(res,s,target));
}
public static int cards(List<String> res,int s,String target)
{
    int e=res.indexOf(target);
    int n=res.size();
    if(s==e)
    return 1;
    if(Math.abs(s-e)==1)
    return 0;
    int forw=0;
    int back=0;
    if(s<e)
    {
        forw=e-s;
        back=s+(n - 1- e)+1;
    }
    else{
        forw=e+(n-1-s)+1;
        back=s-e;
    }
    return Math.min(forw,back);
}
}