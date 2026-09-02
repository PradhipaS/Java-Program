// Find the First Non-Repeating Character from a Stream of Characters
// Problem Statement
// In log analysis for error detection, process a stream of characters (string) to find the first unique character that doesn't repeat, indicating a rare event.

// Sample Input
// swiss

// Sample Output
// First non-repeating character: w
import java.util.*;
public class Non{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s=sc.nextLine();
        String res1= s.toUpperCase();

        Map<Character,Integer> res=new HashMap<>();

        for(char a:res1.toCharArray()){
 res.put(a,res.getOrDefault(a,0)+1);
        }

         for(char a:res1.toCharArray()){
            if(res.get(a)==1)
            {
              System.out.println(a);
              break;
            }
        }
    }
}