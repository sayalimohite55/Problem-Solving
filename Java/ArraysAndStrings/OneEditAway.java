/**
* Question: On Edit Away
* 			There are three types of edits that can be performed on strings: insert, replace, remove a character.
*			Given two strings write a function to check if they are one edit or zero edits away.
* Example:  
* 			pale, ple => true
*			pales, pale => true
* 			pale, bale => true
*			pale, bale => false
*/

import java.util.Hashtable;
import java.util.Map;

class Solution {
	public static boolean isOneOrZeroEditAway(String s1, String s2) {
		if(Math.abs(s1.length()-s2.length()) > 1 ) return false;
		
		String p,q;
		if(s1.length() > s2.length()) {
			p = s1;
			q = s2;
		}
		else {
			p = s2;
			q = s1;
		}
		
		Hashtable<Character,Integer> map = new Hashtable<>();
		for(int i=0;i<p.length();i++) {
			char ch = p.charAt(i); 
			if(map.containsKey(ch))
				map.put(ch, map.get(ch)+1);
			else
				map.put(ch,1);
		}
		
		int editCount =0;
		for(int i=0;i<q.length();i++) {
			char ch = q.charAt(i);
			if(map.containsKey(ch)) {
				int count = map.get(ch);
				if(count > 1)
					map.put(ch,count-1);
				else
					map.remove(ch);
			}
			else
				editCount ++;
		}
		
		if(map.size() == 0 && editCount <= 1 ) return true;
		else if(map.size() == 1 && editCount <= 1) {
			for(Map.Entry entry : map.entrySet()) {
				if((int)entry.getValue() == 1) return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
	System.out.println("isOneOrZeroEditAway : "+isOneOrZeroEditAway("pale","bale"));
	}
}
