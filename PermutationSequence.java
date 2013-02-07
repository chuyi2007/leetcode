public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n];
        for(int i = 1; i <= n; ++i)
            num[i - 1] = i;
        int count = 1;
        while(count < k){
            int index = 0;
            for(int i = n - 1; i > 0; --i){
                if(num[i] > num[i - 1]){
                    index = i - 1;
                    break;
                }
            }
            for(int i = n - 1; i > index; --i){
                if(num[i] > num[index]){
                    swap(num, i, index);
                    break;
                }
            }
            for(int i = n - 1, j = index + 1; i > j; --i, ++j){
                swap(num, i, j);
            }
            count++;
        }
        String result = "";
        for(int i = 0; i < n; ++i)
            result += String.valueOf(num[i]);
        return result;
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}

public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n];
        for(int i = 0; i < n; ++i)
            num[i] = i + 1;
        
        for(int i = 2; i <= k; ++i){
            nextPermutation(num);
        }
        
        StringBuffer sb = new StringBuffer();
        for(int val: num)
            sb.append(val);
        return sb.toString();
    }
    
    public void nextPermutation(int[] num){
        int pivot = -1;
        for(int i = num.length - 1; i > 0; --i){
            if(num[i - 1] < num[i]){
                pivot = i - 1;
                break;
            }
        }
        if(pivot == -1){
            for(int i = 0; i < num.length; ++i)
                num[i] = i + 1;
            return;
        }
        for(int i = num.length - 1; i > pivot; --i){
            if(num[i] > num[pivot]){
                swap(num, i, pivot);
                break;
            }
        }
        for(int i = num.length - 1, j = pivot + 1; i > j;){
            swap(num, i, j);
            --i;
            ++j;
        }
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}