/**
* Question: Implement an algorithm to determine if a string has all unique characters.
* 			Also, what if you can not use additional datastructures?
*/

import java.util.HashSet;


class IsUnique {

	public static boolean isUnique(String str) {
	/**
	* Here in this approach we have used extra space for a data structure set.
	* set stores only unique values so we can easily identify if a character repeats
	*/
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<str.length(); i++) {
			char ch=str.charAt(i);
			if(set.contains(ch))
				return false;
			else set.add(ch);
		}
		return true;
	}

	public static boolean isUniqueUsingBitManipulation(String str) {
	
		int checker =0;
		for(int i=0;i<str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			if((checker & (1<<val)) >0)
				return false;
			checker |= ( 1<<val);		
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println("\n check isUnique for 'Hello World' using extra data structure space: "+isUnique("Hello World"));
		System.out.println("\n check isUnique for 'Pune' without using extra data structure space: "+isUniqueUsingBitManipulation("Pune"));	
	}
}
