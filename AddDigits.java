public class Solution {
    public int addDigits(int num) {
        return num == 0 ? 0 : (1 + (num - 1) % 9);
    }
    
    public int useLoop(int num) {
        while (num >= 10) {
            int tmp = num;
            int res = 0;
            while (tmp >= 10) {
                res += tmp % 10;
                tmp /= 10;
            }
            res += tmp;
            num = res;
        }
        return num;
    }
}
