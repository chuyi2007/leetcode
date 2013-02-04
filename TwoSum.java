public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] r = new int[2];
        for(int i = 0; i < numbers.length; ++i){
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i], i);
            }
            else if(2 * numbers[i] == target){
                r[0] = map.get(numbers[i]) + 1;
                r[1] = i + 1;
                return r;
            }
        }
        Arrays.sort(numbers);
        for(int i = 0, j = numbers.length - 1; j > i;){
            int sum = numbers[i] + numbers[j];
            if(sum > target)
                --j;
            else if(sum < target)
                ++i;
            else{
                int x = map.get(numbers[i]) + 1, y = map.get(numbers[j]) + 1;
                r[0] = Math.min(x, y);
                r[1] = Math.max(x, y);
                break;
            }
        }
        return r;
    }
}

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; ++i)
            map.put(numbers[i], i);
        Arrays.sort(numbers);
        int[] indexs = new int[2];
        for(int i = 0, j = numbers.length - 1; i <= j;){
            int sum = numbers[i] + numbers[j];
            if(sum > target)
                --j;
            else if(sum < target)
                ++i;
            else{
                indexs[0] = Math.min(map.get(numbers[i]), map.get(numbers[j])) + 1;
                indexs[1] = Math.max(map.get(numbers[i]), map.get(numbers[j])) + 1;
                break;
            }
        }
        return indexs;
    }
}