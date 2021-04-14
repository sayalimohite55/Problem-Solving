/**
* Question: Given two sorted arrays, find the number of elements in common. The arrays are of the same length
*			and each has all distinct elements.
*/

class Solution {

	public static void main(String args[]) {
	
		int arr1[] = {13,27,35,40,49,55,59};
		int arr2[] = {17,35,39,40,55,58,60};
		
		int count=0;
		for(int i=0, j=0;i<arr1.length && j<arr1.length;)
		{
			if(arr1[i] == arr2[j]) {
				count++;
				i++;
				j++;
			}
			else if( arr1[i] < arr2[j]) i++;
			else j++;
		}
		System.out.println("\n Number of common elements in given arrays is : "+count);
	}
}
