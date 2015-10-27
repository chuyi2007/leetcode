// truth table
public class Solution {
    public int singleNumber(int[] nums) {
        int first = 0, second = 0;
        for (int i : nums) {
            int lastFirst = first;
            first = second & i | first & (~i);
            second = ~lastFirst & ~second & i | second & (~i);
        }
        return second;
    }
}
