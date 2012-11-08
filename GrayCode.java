public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> results = new ArrayList<Integer>();
        int total = (int) Math.pow(2,n);
        int init = 0;
        results.add(init);
        for(int i = 1; i < total; ++i){
            int previous = results.get(i - 1);
            if(i % 2 != 0){
                int next = (previous%2 == 0)?previous + 1: previous - 1;
                results.add(next);
            }
            else{
                int count = 0;
                int next = previous;
                while(next %2 == 0){
                    next = next >> 1;
                    ++count;
                }
                int q = (int)Math.pow(2, count);
                int d = ((next >> 1) % 2 == 0)?next + 2: next - 2;
                next = d * q + previous % q;
                results.add(next);
            }
        }
        return results;
    }
}