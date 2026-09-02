//  Spiral Traversal of a Matrix
// Problem Statement
// Write a program to print the spiral traversal of a given matrix.

// Input Format
// First line: two integers ROW COL
// Next ROW lines: COL integers each for the matrix
// Output Format
// Print "Spiral traversal of the matrix is: " followed by the elements in spiral order separated by space
// Sample Input
// 4 4
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// 13 14 15 16
// Sample Output
// Spiral traversal of the matrix is: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ROW = scanner.nextInt();
        int COL = scanner.nextInt();
        int[][] matrix = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int top=0,bottom=ROW-1,left=0,right=COL-1;
         while(top<=bottom && left<=right)
         {
            for(int i=left;i<=right;i++)
            {
                System.out.print(matrix[top][i]+" ");
              }  top++;
            
             for(int i=top;i<=bottom;i++)
            {
                System.out.print(matrix[i][right]+" ");
            }right--;
    
            if(top<=bottom)
            {
            for(int i=right;i>=left;i--)
            {
                System.out.print(matrix[bottom][i]+" ");
             } bottom--;
             }
            if(left<=right){
                for(int i=bottom;i>=top;i--)
            {
                System.out.print(matrix[i][left]+" ");
            }left++;
            
            }
         }
         System.out.println();
    }}