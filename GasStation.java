public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = gas.length;
        int tank = -1;
        int index = -1;
        for (int i = 0; i < n; ++i) {
            int cur = gas[i] - cost[i];
            if (tank >= 0) {
                tank += cur;
                index = tank >= 0 ? index : -1;
            }
            else if (cur >= 0) {
                tank = cur;
                index = i;
            }
        }
        
        for (int i = 0; i <= index; ++i) {
            tank += gas[i] - cost[i];
        }
        return tank >= 0 ? index : -1;
    }
    //O(N^2), time limit
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = gas.length;
        for (int i = 0; i < n; ++i) {
            if (gas[i] > cost[i]) {
                int tank = 0;
                boolean flag = true;
                for (int j = i; j < i + n; ++j) {
                    int index = j % n;
                    if (tank + gas[index] < cost[index]) {
                        flag = false;
                        break;
                    }
                    tank += gas[index] - cost[index];
                }
                if (flag)
                    return i;
            }
        }
        
        return -1;
    }
}