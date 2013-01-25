<<<<<<< HEAD
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        HashSet<Integer> uniqueNum = new HashSet<Integer>();
        int size = num.length;
        for(int i = 0; i < size; i++)
            uniqueNum.add(target - num[i]);
        Iterator<Integer> uniqueNumIter = uniqueNum.iterator();
        HashSet<ArrayList<Integer>> uniqueResults = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        while(uniqueNumIter.hasNext()){
            int newTarget = uniqueNumIter.next();
	        for(int i = 0; i < size; i++){
	        	int a = num[i];
	        	for(int j = i + 1, k = size - 1; k > j;){
	        		int b = num[j];
	        		int c = num[k];
	        		int sum = a + b + c;
	        		int diff = sum - newTarget;
	        		if(diff > 0)
	        			k--;
	        		else if(diff < 0)
	        			j++;
	        		else{
	        			ArrayList<Integer> result = new ArrayList<Integer>();
	        			int d = target - newTarget;
	        			if(d < a){
	        				result.add(d);
	        				result.add(a);
	        				result.add(b);
	        				result.add(c);
	        			}
	        			else if (d < b){
	        				result.add(a);
	        				result.add(d);
	        				result.add(b);
	        				result.add(c);
	        			}
	        			else if (d < c){
	        				result.add(a);
	        				result.add(b);
	        				result.add(d);
	        				result.add(c);
	        			}
	        			else{
	        				result.add(a);
	        				result.add(b);
	        				result.add(c);
	        				result.add(d);
	        			}
                        if(!uniqueResults.contains(result)){
                            uniqueResults.add(result);
                            results.add(result);
                        }
	        		}
	        	}
	        }
        }
        return results;
    }
=======
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                for(int k = j + 1, l = num.length - 1; k < l;){
                    int sum = num[i] + num[j] + num[k] + num[l];
                    int diff = sum - target;
                    if(diff > 0)    l--;
                    else if(diff < 0)   k++;
                    else{
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);
                        tmp.add(num[l]);
                        result.add(tmp);
                        k++;
                        l--;
                    }
                    while(k < l - 1 && num[k] == num[k + 1])
                        k++;
                    while(l > k + 1 && num[l] == num[l - 1])
                        l--;
                }
                while(j < num.length - 1 && num[j] == num[j + 1])
                    j++;
            }
            while(i < num.length - 1 && num[i] == num[i + 1])
                i++;
        }
        return result;
    }
>>>>>>> c7e6da8ff411d4733e842c714bad6d0f5ad976de
}