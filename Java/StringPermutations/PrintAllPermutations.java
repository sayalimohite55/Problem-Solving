/**
* Question : Write a program to print all permutations of a string
*/

class StringPermutations {

	public static int printPermutations(String str, String prefix, int count) {
	
		if(str.length() == 0)
		{
			count++;
			System.out.println(count+" : "+prefix);
			return count;
		}
		else {
			for(int i=0;i<str.length();i++) {
				String rem = str.substring(0,i) + str.substring(i+1);
				count = printPermutations(rem,prefix+str.charAt(i), count);
			}
		}
		return count;
	}
	
	
	public static void main(String args[]) {
	
		String str = "Sayali";
		printPermutations(str,"",0);
	}
}
