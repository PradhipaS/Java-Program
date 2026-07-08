

/*Given a sequence of integers, determine whether it is a valid stack pop sequence for some push sequence of the integers 1 to n in increasing order. Assume the push sequence is always 1 to n in order. A sequence is valid if it can be achieved by pushing the numbers 1 to n in order onto a stack and popping at arbitrary points.

Input Format:

The first line contains an integer n (number of elements in the sequence)
The second line contains n space-separated integers representing the pop sequence
Output Format:

Print YES if the sequence is a valid stack pop sequence, otherwise print NO
Constraints:

1 ≤ n ≤ 105
1 ≤ sequence[i] ≤ n
All integers in the sequence are unique
Sample Input:

5
4 5 3 2 1
Sample Output:

YES
*/
package demo;
import java.util.Scanner;
import java.util.Stack;
public class Stack1 {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []Sequence= new int[n];
		for(int i=0;i<n;i++) {
			Sequence[i]=sc.nextInt();
		}
		Stack <Integer>stack= new Stack<>();
		int index=0;
		for(int i=1;i<=n;i++) {
			stack.push(i);
			if(!stack.isEmpty() && stack.peek()==Sequence[index])
			{
				stack.pop();
				index++;
			}
		}
		System.out.println(index==n?"YES":"NO");
		sc.close();
				
	}

}
