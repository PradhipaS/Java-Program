import java.util.*;
public class P5{
    public static void main(String[] args) {
        {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int ex=sc.nextInt();
            int[] p=new int[n];
            int[] b=new int[n];
            for(int i=0;i<n;i++)
            {p[i]=sc.nextInt();
            }
            for(int i=0;i<n;i++)
            {
                b[i]=sc.nextInt();
            }
            List<int[]>a=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
              a.add(new int[]{p[i],b[i]});
            }
            a.sort(Comparator.comparingInt(x->x[0]));
            int ans=0;
            for(int[] pair:a)
            {
                int point=pair[0];
                int bo=pair[1];
                if(point>ex)
                {
                    break;
                }
                ex=ex+bo;
                ans++;
            }
System.out.println(ans);
        }
    }
}