/**
* Question : Given a smaller string s and bigger string b, implement an algorithm to find all permutations 
* 			 of smaller string into bigger string. Print the location of each permutation.
* For example :
* 			 Smaller string : abbc
* 			 Bigger String : cbabadcbbabbcbabaabccbabc
* Output : 	 7 permutations found at 0 cbab, 6 cbba, 9 abbc, 11 bcba, 12 cbab, 20 cbab, 21 babc 
*/
import java.util.HashSet;

class StringPermutations {

	public static void findAllPermutations(String str, String prefix, HashSet<String> set) {
	
		if(str.length() == 0)
		{
			set.add(prefix);
		}
		else {
			for(int i=0;i<str.length();i++) {
				String rem = str.substring(0,i) + str.substring(i+1);
				findAllPermutations(rem,prefix+str.charAt(i), set);
			}
		}
	}

	public static void locateAndPrintPermutations(String biggerString, String smallerString) {
		HashSet<String> set = new HashSet<>();
		findAllPermutations(smallerString,"",set);
		
		int n = smallerString.length();
		for(int i=0; i <= biggerString.length() - n; i++) {
			String subString = biggerString.substring(i,i+n);
			if(set.contains(subString))
				System.out.println(i+" : "+	subString);	
		}
	}
		
	public static void main(String args[]) {
	
		locateAndPrintPermutations("cbabadcbbabbcbabaabccbabc","abbc");
	}
}
