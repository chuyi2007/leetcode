import java.util.HashSet;
public class Solution {
    //iterative solution
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = s.length();
        HashSet<String> set = new HashSet<String>();
        for(int i = 1; i <= 26; i++)
            set.add(String.valueOf(i));
        int f1 = 0, f2 = 0, f3 = 0;
        if(size == 0)
            return 0;
        else if(size == 1){
            if(set.contains(s))
                return 1;
        }
        else if(size >= 2){
            if(set.contains(s.substring(0,1)))
                f1++;
            if(set.contains(s.substring(0,1)) && set.contains(s.substring(1,2)))
                f2++;
            if(set.contains(s.substring(0,2)))
                f2++;
        }
        if(size == 2)
            return f2;
        for(int i = 2; i < size; i++){
            int tmpF3 = 0;
            if(set.contains(s.substring(i,i + 1)))
                tmpF3 +=f2;
            if(set.contains(s.substring(i - 1,i + 1)))
                tmpF3 += f1;
            f3 = tmpF3;
            f1 = f2;
            f2 = tmpF3; 
        }
        return f3;
    }
    
    //recursive solution
    public int decodingCheck(String s, HashSet<String> set, int i){
        int size = s.length();
        int result = 0;
        if(size == i && size != 0)
            return 1;
        else{
            if(i < size && set.contains(s.substring(i, i+1)))
                result += decodingCheck(s, set, i+1);
            if(i < size - 1 && set.contains(s.substring(i, i+2)))
                result += decodingCheck(s, set, i+2);
        }
        return result;
    }
}