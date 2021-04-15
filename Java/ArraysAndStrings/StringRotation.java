/**
* Question: String Rotation
*			Assume that you have a method isSubString which checks if one word is a substring of another.
*			Given two strings s1 and s2, write code to check if s2 is a rotation of s1 using only one call
*			to isSubString.
*			For example : "waterbottle" is a rotation of "erbottlewat".
*/

class Solution {

	public static boolean isSubString(String s1, String s2) {
		return s2.contains(s1);
	}
	
	public static boolean isRotation(String s1, String s2) {
		StringBuilder builder = new StringBuilder(s2);
		builder.append(s2);
		
		return isSubString(s1,builder.toString());
	}
	
	public static void main(String[] args) {
		System.out.println("Is s1 a rotation of S2 : " + isRotation("waterbottle","erbottlewat"));
	}
}
