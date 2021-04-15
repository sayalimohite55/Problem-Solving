/**
* Question: Palindrome Permutation
* 			Given a string write a function to check if it is a permutation of a palindrome.
*			A palindrome is a word or phraise i.e same forwards and backwards.
*			The permutation is rearrangement of letters. The palindrome does not need to be limited to 
*			just dictionary words.
* Example:  "Tact Coa"
* Output:	True (permutations "taco cat", "atco cta", etc)
*/

import java.util.Hashtable;

class Solution {
	public static boolean isPalindromePermutation(String str) {
		Hashtable<Character,Integer> map = new Hashtable<>();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch == ' ') continue; 
			if(map.containsKey(ch))
			{
				int count = map.get(ch);
				if((count+1) % 2 == 0)
					map.remove(ch);
				else
					map.put(ch, map.get(ch)+1);
			}
			else
				map.put(ch,1);
		}
		
		System.out.println("size : "+map.size());
		
		if(map.size() <= 1)
			return true;
		return false;
	}

	public static void main(String args[]) {
	System.out.println("isPalindromicPermutation : "+isPalindromePermutation("taco cat"));
	}
}
