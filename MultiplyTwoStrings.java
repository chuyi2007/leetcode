public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String l, s;
        if(num1.length() > num2.length()){
            l = num1;
            s = num2;
        }
        else{
            l = num2;
            s = num1;
        }
        int preCarry = 0;
        int[] pro = new int[l.length() + s.length()];
        for(int i = s.length() - 1; i >= 0; --i){
            preCarry = 0;
            int a = s.charAt(i) - 48;
            for(int j = l.length() - 1; j >= 0; --j){
                int b = l.charAt(j) - 48;
                int sum = a * b + preCarry;
                pro[i + j + 1] += sum % 10;
                preCarry = sum/10;
            }
            pro[i] = preCarry;
        }
        preCarry = 0;
        for(int i = pro.length - 1; i >= 0; --i){
            int sum = pro[i] + preCarry;
            pro[i] = sum % 10;
            preCarry = sum / 10;
        }
        
        String result = "";
        if(pro[0] != 0)
            result += String.valueOf(pro[0]);
        boolean zeroFlag = true;
        for(int i = 1; i < pro.length; ++i){
            if(pro[i] > 0)
                zeroFlag = false;
            result += String.valueOf(pro[i]);
        }
        return zeroFlag?"0":result;
    }
}