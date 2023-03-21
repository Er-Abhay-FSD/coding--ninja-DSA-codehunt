/***************************************************************************
                    Group 2 Set 1
****************************************************************************/

/*  MCQ   */

/*
int getans(int n)
    lv = 1
    ans=0
    while(lv * lv <= n)
        inner_lv = n
        while(inner_lv > 0)
            inner_lv- = lv
        lv++
        ans++

return ans
    
    
    
Ans: nlogn


func(int n)
    if(n==1)
        return 
    lv=1
    while(lv <= n)
        inner_lv=1
        while(inner_lv <= n)
            print (“#”)
            return
            inner_lv++
    lv++
    
    
Ans: O(1)


class Vehicle{
    String colour;
    private int number;
    void print()
    {
        System.out.println("vehicle");
    }
}

class Car extends Vehicle{
    void print()
    {
        System.out.println("car");
    }
}
class Honda extends Car{
    void print()
    {
        System.out.println("Honda");
    }
}
class buy_car{
    public static void main (String[] args) {
        Car c=new Car();
        c.print();
    }
}


Ans: Car
*/


/***************************************************************************
                    Power
****************************************************************************/
import java.util.*;
public class Solution {
	public static int superPow(int a, int[] b) {
    if (a % 1337 == 0) return 0;
    int p = 0;
    for (int i : b) p = (p * 10 + i) % 1140;
    if (p == 0) p += 1440;
    a %= 1337;
    int result = 1;
    while (p > 0) {
        if ((p & 1) != 0) result = result * a % 1337;
        a = a * a % 1337;
        p >>= 1;
    }
    return result;
}
public static int power(int a, int n, int mod) {
    a %= mod;
    int ret = 1;
    while (n != 0) {
        if ((n & 1) != 0) ret = ret * a % mod;
        a = a * a % mod;
        n >>= 1;
    }
    return ret;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.print("Enter the number(power): ");
        int a = sc.nextInt();
       // System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
          //  System.out.print("Enter "+ i+ "th value in array: " );
            arr[i]=sc.nextInt();

        }
        System.out.print(superPow(a,arr));
    }
}



/***************************************************************************
                    All Possible Way
****************************************************************************/

public class Solution {
     static int power(int num, int n)
    {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return power(num, n / 2) * power(num, n / 2);
        else
            return num * power(num, n / 2)
                * power(num, n / 2);
    }
 
    // Function to check power representations recursively
    static int checkRecursive(int x, int n, int curr_num,
                              int curr_sum)
    {
        // Initialize number of ways to express
        // x as n-th powers of different natural
        // numbers
        int results = 0;
 
        // Calling power of 'i' raised to 'n'
        int p = power(curr_num, n);
        while (p + curr_sum < x) {
            // Recursively check all greater values of i
            results += checkRecursive(x, n, curr_num + 1,
                                      p + curr_sum);
            curr_num++;
            p = power(curr_num, n);
        }
 
        // If sum of powers is equal to x
        // then increase the value of result.
        if (p + curr_sum == x)
            results++;
 
        // Return the final result
        return results;
    }
    
    public static int allWays(int x, int n) {
       return checkRecursive(x,n,1,0);
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */

    }
}



/***************************************************************************
                    Quadruplet Sum
****************************************************************************/


import java.util.*;
public class Solution
{
     public static List<List<Integer>> quadruplets(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;

		Arrays.sort(nums);

		int max = nums[len - 1];
		if (4 * nums[0] > target || 4 * max < target)
			return res;

		int i, z;
		for (i = 0; i < len; i++) {
			z = nums[i];
			if (i > 0 && z == nums[i - 1])// avoid duplicate
				continue;
			if (z + 3 * max < target) // z is too small
				continue;
			if (4 * z > target) // z is too large
				break;
			if (4 * z == target) { // z is the boundary
				if (i + 3 < len && nums[i + 3] == z)
					res.add(Arrays.asList(z, z, z, z));
				break;
			}

			threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
		}

		return res;
	}

	/*
	 * Find all possible distinguished three numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, the three numbers))
	 */
	public static void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1) {
		if (low + 1 >= high)
			return;

		int max = nums[high];
		if (3 * nums[low] > target || 3 * max < target)
			return;

		int i, z;
		for (i = low; i < high - 1; i++) {
			z = nums[i];
			if (i > low && z == nums[i - 1]) // avoid duplicate
				continue;
			if (z + 2 * max < target) // z is too small
				continue;

			if (3 * z > target) // z is too large
				break;

			if (3 * z == target) { // z is the boundary
				if (i + 1 < high && nums[i + 2] == z)
					fourSumList.add(Arrays.asList(z1, z, z, z));
				break;
			}

			twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
		}

	}

	/*
	 * Find all possible distinguished two numbers adding up to the target
	 * in sorted array nums[] between indices low and high. If there are,
	 * add all of them into the ArrayList fourSumList, using
	 * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
	 */
	public static void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
			int z1, int z2) {

		if (low >= high)
			return;

		if (2 * nums[low] > target || 2 * nums[high] < target)
			return;

		int i = low, j = high, sum, x;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

				x = nums[i];
				while (++i < j && x == nums[i]) // avoid duplicate
					;
				x = nums[j];
			7	while (i < --j && x == nums[j]) // avoid duplicate
					;
			}
			if (sum < target)
				i++;
			if (sum > target)
				j--;
		}
		return;
	}
    
}