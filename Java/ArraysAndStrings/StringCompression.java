/**
* Question: Implement a method to perform basic string compression using the counts of repeated characters.
*			For example the string aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller
*			than the original string then your method should return the original string. You can assume that the
* 			string has only uppper case and lower case letters.
*/


class Solution {

	public static String compress(String str) {
		StringBuilder s = new StringBuilder("");
		int length = str.length();
		for(int j,i=0;i<length;) {
			char ch = str.charAt(i);
			int count = 1;
			for(j=i+1; j<length && ch == str.charAt(j); count++,j++);
			
			s.append(ch);
			s.append(count);
			
			i=j;
		}
		
		if(s.length() < length)
			return s.toString();
		return str;		
	}
	
	public static void main(String[] args) {
		System.out.println("Compressed String: "+compress("aabcccccaaa"));
	}
}
