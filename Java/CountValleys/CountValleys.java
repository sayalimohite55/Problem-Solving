import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
        Stack<Character> stack = new Stack<>();
        int count=0;
        stack.push(path.charAt(0));
        for(int i=1; i<steps;i++) {
        	char ch = path.charAt(i);
			/*
			* Check if stack is empty 
			* Check if stack contains D and next step is U, and vice versa
			*/
            if(!stack.isEmpty() && ((ch == 'D' && stack.peek() == 'U') ||(ch == 'U' && stack.peek() == 'D'))) {
                stack.pop();
				//check if after pop stack becomes empty
                if(ch == 'U' && stack.isEmpty())
                    count++;
            } else {
                stack.push(ch);
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

