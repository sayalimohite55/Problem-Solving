/**
* Question: Write a program that computes Nth fibonacci number.
* 	Fib Series : F3 = f1+f2, initially f1=0 and f2=1
*/

import java.util.Scanner;

class NthFibNo {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the value of N: ");
		int n = scan.nextInt();
		
		int f1=0, f2=1, f3=0;
		if(n == 1) System.out.print("\n Nth Fib No is: "+f1);
		else if(n == 2) System.out.print("\n Nth Fib No is: "+f2);
		else {
			for(int i=3; i <= n; i++) {
				f3=f1+f2;
				f1=f2;
				f2=f3; 
			}
			System.out.print("\n Nth Fib No is: "+f3);
		}
	}
}
