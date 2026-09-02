// Convert Decimal Number to Hexadecimal Number
// Problem Statement
// Write a program to convert a decimal number to its hexadecimal representation.

// Input Format
// First line: an integer n (decimal number)
// Output Format
// Print "Hexadecimal representation of <n> is: <hex>"
// Sample Input
// 1457

// Sample Output
// Hexadecimal representation of 1457 is: 5B1
import java.util.*;
public class Q2{
    public static void main(String[] args) {
        {
            Scanner sc=new Scanner(System.in);
            int num=sc.nextInt();
            System.out.println(oct(num));
        }
    }
    public static String oct(int num)
    {
         if(num==0)
         return "0";
    StringBuilder s=new StringBuilder();
         while(num!=0)
         {
            int temp=num%16;
            if(temp<10)
            {
             s.append(temp);
            }
            else{
                s.append((char)(temp-10+'A'));
            }
            num=num/16;
         }
         return s.reverse().toString();
    }
}