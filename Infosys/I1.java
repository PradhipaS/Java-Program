// // Problem 2: Coding Round Example - Find the Subset
// // Problem Statement:
// // Given a given set of non-negative integers and a target sum, print all the subsets that sum up to the target sum.
import java.util.*;
 public class I1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int num[]= new int[a];
        for (int i = 0; i < a; i++) {
            num[i]=sc.nextInt();
        }
        int Target=sc.nextInt();
        Arrays.sort(num);
        List<List<Integer>> res= new ArrayList<>();
        find (num,0,Target,new ArrayList<>(),res) ;

        if (res.isEmpty()) {
            System.out.println("No subsets found.");
        } else {
            for (List<Integer> subset : res) {
                System.out.println(subset);
            }
        }

    }
    public static void find(int[]num,int index,int target,List<Integer>cur,List<List<Integer>> res)
    {
        if(num==null || num.length==0)
        {
            return;
        }
        if(target==0)
        {
            res.add(new ArrayList<>(cur));
        }
        if(index>num.length && target<0 )
        {
            return ;
        }
        for(int i=index;i<num.length;i++)
        {
        if(i>index && num[i]==num[i-1])
        {
            continue;
        }
        if(num[i]>target)
        {
            break;
        }
        cur.add(num[i]);
        find ( num, i+1,target-num[i],cur,res);
        cur.remove(cur.size()-1);
    }
    }
    }