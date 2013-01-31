public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return longDivide(dividend, divisor);
    }
    
    //pretty smart but will overflow
    public int logDivide(int dividend, int divisor){
        int result = (int)Math.pow(10, Math.log10(Math.abs(dividend)) 
        - Math.log10(Math.abs(divisor)));
        return (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ) ? result : -result;
    }
    
    //Use long to avoid overflow
    public int longDivide(int dividend, int divisor){
        long result = 0L;
        long posDividend = Math.abs((long)dividend);
        long posDivisor = Math.abs((long)divisor);
        long tmpDividend, tmpDivisor;
        
        if(posDividend == posDivisor)
            result = 1;
        else
            while(posDividend >= posDivisor){
                tmpDividend = posDividend >> 1;
                tmpDivisor = posDivisor;
                long count = 1;
                while(tmpDividend >= tmpDivisor){
                    tmpDivisor = tmpDivisor << 1;
                    count = count << 1;
                }
                posDividend -= tmpDivisor;
                result += count;
            }
        //return (int)-result;
        return (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ) ? (int)result : (int)-result;
    }
}