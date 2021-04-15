/**
* Question: Given two strings, write a method to check if one is a permutation of other.
*/
import java.util.Hashtable;

class Solution {

	public static boolean isPermutation(String s1, String s2) {
		Hashtable<Character, Integer> map = new Hashtable<>();
		
		for(int i=0 ; i<s1.length() ; i++) {
			char ch=s1.charAt(i);
			if(map.containsKey(ch))
				map.put(ch,map.get(ch)+1);
			else
				map.put(ch,1);
		}
		
		for(int i=0;i<s2.length(); i++) {
			char ch=s2.charAt(i);
			if(map.containsKey(ch)) {
				int count = map.get(ch);
				if(count > 1) {
					count--;
					map.put(ch,count);
				}
				else map.remove(ch);
			}
			else
				return false;
		}
		
		if(map.size() == 0)
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		System.out.println("isPermutation : "+isPermutation("abaac","abaca"));
	}
}
