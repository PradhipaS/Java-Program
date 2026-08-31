import java.util.*;
public class P6{
    public static void main(String[] args) {
        
            Scanner sc=new Scanner(System.in);
            int M=sc.nextInt();
            int min=2;
            for(int i=min;i<M;i++){
                if(allsame(M,i))
                {
                    System.out.println(i);
                    break;
                }
            }
    }
        public static boolean allsame(int M,int B)
        {  Set<Integer> res=new HashSet<>();
            int val=M;
            while(val>0)
            {   
res.add(val%B);
val=val/B;
            }
            return res.size()==1;
        }
    }
