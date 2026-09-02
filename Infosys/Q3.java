// 6. Convert Octal Number to Binary Number
// Problem Statement
// Write a program to convert an octal number to its binary representation.

// Input Format
// First line: an integer (octal number)
// Output Format
// Print "Binary representation: <binary>"
// Sample Input
// 10

// Sample Output
// Binary representation: 1000
import java.util.*;
public class Q3{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int num=octtode(n);
        System.out.println(binary(num));
    }
    public static int octtode(int n)
    {
        int deci=0;
        int base=1;
        while(n!=0)
        {    int last=n%10;
            deci=deci+base*last;
            base=base*8;
            n=n/10;
        }
        return deci;
    }
    public static String binary(int num){
          if(num==0)
          return "0";
          StringBuilder s=new StringBuilder();

          while(num!=0)
          {
            s.append(num%2);
            num=num/2;
          }
          return s.reverse().toString();
    }
}