/***************************************************************************
                    Group 1 Set 1
****************************************************************************/

/*  MCQ   */

/*

*/


/***************************************************************************
                    Binary Sum

****************************************************************************/

import java.util.*;

public class Solution {
	public static String addBinary2(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int digitA = i < 0 ? 0 : a.charAt(i--) - '0';
            int digitB = j < 0 ? 0 : b.charAt(j--) - '0';
            sum.insert(0, (digitA + digitB + carry) % 2);
            carry = (digitA + digitB + carry) / 2;
        }
        return sum.toString();
    }

	 static String addBinary(String a, String b)
    {    
          //If the inputs are 0
        if(a.charAt(0) == '0' && b.charAt(0) == '0'){
             return "0";
        }
        // Initialize result
        StringBuilder result = new StringBuilder(""); 
          
        // Initialize digit sum
        int s = 0;         
  
        // Traverse both strings starting 
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {
              
            // Comput sum of last 
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);
  
            // If current digit sum is 
            // 1 or 3, add 1 to result
            result.append((char)(s % 2 + '0'));
  
            // Compute carry
            s /= 2;
  
            // Move to next digits
            i--; j--;
        }
        
          // Remove leading zeros, if any
          int start = result.length()-1;
          
        while(start >=0 && result.charAt(start) == '0') {
            start--;
        }
          
        if(start != result.length()-1) {
            result.delete(start+1,result.length());
        }
          
        return result.reverse().toString();
    }

	public static void main(String[] args) {
		/* Your class should be named Solution.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
		Scanner sc  = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0){
			String s1 = sc.next();
			String s2 =sc.next();
			
			System.out.println(addBinary2(s1,s2));
			t--;

		}

	}

}





/***************************************************************************
                    Reset Matrix
****************************************************************************/
public class solution {
	 public static void makeRowsCols0(int[][] matrix) {
        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
	
}



/***************************************************************************
                  Pyramid Number Pattern
****************************************************************************/

import java.util.*;
public class Solution {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		n=n+1;
        int i=1;
        while(i<n){
            int sp =1;
            while(sp<n-i){
                System.out.print(" ");
                sp=sp+1;
            }
            int p=i;
            int j=1;
            while(j<=i){
                System.out.print(p);
                p=p-1;
                j=j+1;
            }
            p=2;
            while(p<=i){
                System.out.print(p);
                p=p+1;
            }
            System.out.println();
            i=i+1;

        }
    }
}


/***************************************************************************
                    Amazing Strings
****************************************************************************/
import java.util.HashMap;

public class Solution {
  public static String amazingStrings(String first, String second, String third) {
    // create a map to store the characters of the first and second strings
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < first.length(); i++) {
      char c = first.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < second.length(); i++) {
      char c = second.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    // check if all characters of the first and second strings are present in the third string
    for (int i = 0; i < third.length(); i++) {
      char c = third.charAt(i);
      if (map.containsKey(c)) {
        int count = map.get(c);
        // decrement the count for the current character
        count--;
        // if the count is 0, remove the character from the map
        if (count == 0) {
          map.remove(c);
        } else {
          // update the count for the current character
          map.put(c, count);
        }
      }
    }

    // check if the map is empty
    if (map.isEmpty()) {
      return "YES";
    } else {
      return "NO";
    }
  }
}


