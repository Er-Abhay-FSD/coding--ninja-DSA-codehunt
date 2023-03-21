/***************************************************************************
                    Group 4 Set 1
****************************************************************************/

/*  MCQ   */

/*

*/


/***************************************************************************
                    Minimum Character Deletion

****************************************************************************/
import java.util.*;

public class Solution {
    static int minCntCharDeletionsfrequency(char[] str, int N) {
        Map<Character, Integer> charCounts = new HashMap<>();
        int count = 0;

        // Get the frequencies of each letter in the string
        for (char c : str) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        // Store the frequencies into an array list
        List<Integer> frequencies = new ArrayList<>(charCounts.values());

        // Initialize a set to store the frequencies
        Set<Integer> set = new HashSet<>();
        for (int value : frequencies) {
            if (!set.contains(value)) {
                set.add(value);
            } else {
                // Decrement the value until it is unique in the set
                while (value > 0 && set.contains(value)) {
                    value--;
                    count++;
                }
                set.add(value);
            }
        }
        return count;
    }

    public static int minCharDeletion(String str) {
        return minCntCharDeletionsfrequency(str.toCharArray(), str.length());
    }
}





/***************************************************************************
                    Sumway
****************************************************************************/
public class Solution {
    public static int minLaneChanges(int[] A) {
        int[] dp = new int[]{1, 0, 1};
        for (int a : A) {
            if (a > 0) {
                dp[a - 1] = 1000000;
            }
            for (int i = 0; i < 3; i++) {
                if (a != i + 1) {
                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
                }
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}




/***************************************************************************
                    # of Atoms
****************************************************************************/
import java.util.*;

public class Solution {
    public static String countNumberOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
            } else if (c == ')') {
                int val = 0;
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    val = val * 10 + formula.charAt(++i) - '0';
                }
                if (val == 0) {
                    val = 1;
                }

                if (!stack.isEmpty()) {
                    Map<String, Integer> temp = map;
                    map = stack.pop();
                    for (String key : temp.keySet()) {
                        map.put(key, map.getOrDefault(key, 0) + temp.get(key) * val);
                    }
                }
            } else {
                int start = i;
                while (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                    i++;
                }
                String atom = formula.substring(start, i + 1);
                int val = 0;
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    val = val * 10 + formula.charAt(++i) - '0';
                }
                if (val == 0) {
                    val = 1;
                }
                map.put(atom, map.getOrDefault(atom, 0) + val);
            }
        }

        StringBuilder result = new StringBuilder();
        List<String> atoms = new ArrayList<>(map.keySet());
        Collections.sort(atoms);
        for (String atom : atoms) {
            result.append(atom);
            if (map.get(atom) > 1) {
                result.append(map.get(atom));
            }
        }

        return result.toString();
    }
}





/***************************************************************************
                    Spl Walk
****************************************************************************/



#include<bits/stdc++.h>

using namespace std;

void dfs1(int i,vector<int>adj[],int n,stack<int>&s,vector<bool>&vis)

{

    vis[i]=true;

    for(auto j:adj[i])

    if(!vis[j])

    dfs1(j,adj,n,s,vis);


 

    s.push(i);

}

void dfs2(int i,vector<int>adj[],vector<bool>&vis,vector<int>&temp)

{

    vis[i]=true;

    temp.push_back(i);

    for(auto j:adj[i])

    if(!vis[j])

    {

        dfs2(j,adj,vis,temp);

    

    }   

}

void findSSC(vector<int>adj[],int n)

{

    stack<int>s;

    vector<bool>vis(n,false);

for(int i=0;i<n;i++)

     {if(!vis[i])

     dfs1(i,adj,n,s,vis);}


 

     for(int i=0;i<n;i++)

     vis[i]=false;


 

     vector<int>rev[n];

     for(int i=0;i<n;i++)

     {

         for(auto j:adj[i])

         rev[j].push_back(i);

     }

     vector<vector<int>>res;

     while(!s.empty())

     {

         int curr=s.top();

         s.pop();

         if(!vis[curr])

         {

             vector<int>temp;

             dfs2(curr,rev,vis,temp);

             res.push_back(temp);

             temp.clear();

         }

     }

     set<int>ss;

     for(int i=0;i<res.size();i++)

     {

        vector<int>t=res[i];

        if(t.size()>=3)

        {

            for(int j=0;j<t.size();j++)

            ss.insert(t[j]);

        }

     }

     for(int i=0;i<n;i++)

     {

         if(ss.find(i)!=ss.end())

         cout<<"1"<<" ";

         else

         cout<<"0"<<" ";

     }

}

int main(){

    int n,m;

    cin>>n>>m;

    vector<int>adj[n];

    for(int i=0;i<m;i++)

    {

        int x;

        int y;

        cin>>x>>y;

        x--;

        y--;

        adj[x].push_back(y);

    }

    findSSC(adj,n);

    return 0;

}

