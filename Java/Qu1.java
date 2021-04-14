/**
* Question : Given an array of distinct integer values, count the number of pairs of integers that have difference k.
* Input : 		N  : no og distinct values
* 				1, 2, 3, ...N  : N distinct integer values
* 				K  : Diff k
*/
import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

class CountPairs {

	public static int countPairsWithDiffK(HashSet<Integer> hashSet, int k) {
		int count = 0;
		Iterator<Integer> iterator = hashSet.iterator();
		while(iterator.hasNext())
		{
			int num = iterator.next();
			if(hashSet.contains(num+k)) count++;
			if(hashSet.contains(num-k)) count++;
		}
		return count;
	}

	public static void main(String args[]) {
		int N,k;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n Enter value of N: ");
		N = scan.nextInt();
		
		HashSet<Integer> hashSet =  new HashSet<>();
		System.out.println("\n Enter N distinct integer values:");
		for(int i=0; i<N ; i++) 
			hashSet.add(scan.nextInt());
			
		System.out.print("\n Enter the value of K: ");
		k = scan.nextInt();
		
		System.out.println("\nNo. of pairs with Diff K are : "+countPairsWithDiffK(hashSet, k));
	}
}
