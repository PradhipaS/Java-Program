// //  Swap Two Numbers Using a Temporary Variable
// // Problem Statement
// // Write a program to swap two numbers using a temporary variable.

// // Input Format
// // First line: an integer a
// // Second line: an integer b
// // Output Format
// // Print "Before swapping: a = , b = "
// // Print "After swapping: a = , b = "
// // Sample Input
// // 5

// // 10

// // Sample Output
// // Before swapping: a = 5, b = 10

// // After swapping: a = 10, b = 5
// import java.util.*;
// // public class Quest{
// //     public static void main(String[] args) {
// //         Scanner sc=new Scanner(System.in);
// //         int a=sc.nextInt();

// //         // int b=sc.nextInt();
// //         // int temp=a;
// //         // a=b;
// //         // b=temp;
// //         // System.out.print("a"+ a +","+"b"+b);
// //     }
// // }
// // // . Convert Decimal Number to Binary Number
// // Problem Statement
// // Write a program to convert a decimal number to its binary representation.

// // Input Format
// // First line: an integer n (decimal number)
// // Output Format
// // Print "Binary representation of <n> is: <binary>"
// // Sample Input
// // 11

// // Sample Output
// // Binary representation of 11 is: 1011

// // public class Quest{
// //     public static void main(String[] args) {
// //         Scanner sc=new Scanner(System.in);
// //         int a=sc.nextInt();
// //         StringBuilder s=new StringBuilder();
// //   if(a==0){
// //     System.out.println("0");
// //   }
// //         while(a>0)
// //         {
// //           s.append(a%2);
// //           a=a/2;
// //         }
// //         System.out.println(s.reverse().toString());
// //     }}
// // Convert Decimal Number to Octal Number
// // Problem Statement
// // Write a program to convert a decimal number to its octal representation.

// // Input Format
// // First line: an integer n (decimal number)
// // Output Format
// // Print "Octal representation of <n> is: <octal>"
// // Sample Input
// // 148

// // Sample Output
// // Octal representation of 148 is: 224
// import java.util.Scanner;

// public class Quest{
//     public static void convertToOctal(int num) {
//         if (num == 0) {
//             System.out.print("0");
//             return;
//         }
//         StringBuilder octal = new StringBuilder();

//         while (num > 0) {
//             octal.append(num % 8);
//             num /= 8;
//         }

//         System.out.print(octal.reverse().toString());
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int n = scanner.nextInt();
//         System.out.print("Octal representation of " + n + " is: ");
//         convertToOctal(n);
//         System.out.println();
//         scanner.close();
//     }
// }