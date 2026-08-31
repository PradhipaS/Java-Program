import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            // Use sc.next() instead of sc.nextLine() to read space-separated tokens
            String a = sc.next();
            String b = sc.next();
            
            int c = Integer.parseInt(a, 2);
            int d = Integer.parseInt(b, 2);
            int temp = c + d;
            
            System.out.println(temp);
            res.add(temp);
        }
        
        if (!res.isEmpty()) {
            int max = Collections.max(res);
            System.out.println(max);
            System.out.println(Integer.toBinaryString(max));
        }
        
        sc.close();
    }
}
