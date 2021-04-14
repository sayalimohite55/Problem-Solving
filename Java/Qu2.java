/**
* Question : Print all positive integer solutions to the given equation : a^3 + b^3 = c^3 + d^3
* 			 Where a, b, c, and d are integers between 1 and 1000
*/

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Solution {

	public static void main(String args[]) {
		// a^3 + b^3 = c^3 + d^3
		
		Map<Double, ArrayList<String>> map = new HashMap<>(); 
		for(int a=1 ; a<=1000 ; a++)
			for(int b=1; b<=1000 ; b++)
			{
				double sum = Math.pow(a,3) + Math.pow(b,3);
				ArrayList<String> list;
				
				if(map.containsKey(sum))
					list = map.get(sum);
				else
					list = new ArrayList<>();
				
				list.add(a+","+b);
				map.put(sum,list);
			}
		// System.out.println("***"+map.size());
		
		for(Map.Entry entry : map.entrySet()) {
			ArrayList<String> list1 = (ArrayList) entry.getValue();
			for(int i=0;i<list1.size(); i++)
				for(int j=0;j<list1.size();j++)
					if(i!=j)
						System.out.println(list1.get(i)+","+list1.get(j));
		}
		
	}
}
