/**
* Question: Write a program that computes fibonacci series up to given N.
* 	Fib Series : F3 = f1+f2, initially f1=0 and f2=1
*/

import java.util.Scanner;

class FibonacciSeriesUpToN {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the value of N: ");
		int n = scan.nextInt();
		
		int f1=0, f2=1, f3=0;
		if(n == 0) System.out.print("\n Fib Series: "+f1);
		else if(n == 1) System.out.print("\n Fib Series: "+f2);
		else {
			System.out.print("\n Fib Series: "+f1+" "+f2);
			while(f3 < n) {
				f3=f1+f2;
				if(f3 > n) break;
				System.out.print(" "+f3);
				
				f1=f2;
				f2=f3; 
			}
		}
	}
}
