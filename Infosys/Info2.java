// Check if a Number is Prime
// Problem Statement
// In cryptography key generation, check if a candidate number is prime to ensure secure prime factors for encryption algorithms.

// Sample Input
// 17

// Sample Output
// Yes
import java.util.*;
public class Info2{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(prime(n) ?"YES":"NO");
    }
    public static boolean prime(int n){
        if(n==0|| n==1)
        {
            return false;

        }
        if(n==2){
        return true;
        }
        for(int i=2;i*i<=n;i+=2)
        {
            if(n%i==0)
            {
            return false;
            }
        }
        return true;
    }
}