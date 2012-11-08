import java.util.HashMap;
public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        
        int remains = num;
        String result = "";
        int base = 1000;
        while(remains > 0){
            int q = remains/base;
            if(q >= 9)  
                result += map.get(base) + map.get(base * 10);
            else if(q >= 5){
                result += map.get(base * 5);
                for(int i = 0; i < q - 5; ++i)
                    result += map.get(base);
            }
            else if(q >= 4)
                result += map.get(base) + map.get(base * 5);
            else if(q >= 1)
                for(int i = 0; i < q; ++i)
                    result += map.get(base);
            remains %= base;
            base /= 10;
        }
        return result;
    }
}