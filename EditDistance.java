public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return dynamicLevenshtein(word1, word2);
    }
    
    //dyanamic programming, O(M*N)
    public int dynamicLevenshtein(String word1, String word2){
        int len1 = word1.length(), len2 = word2.length(), cost;
        int[][] table = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++)
            table[i][0] = i;
        for(int j = 0; j <= len2; j++)
            table[0][j] = j;
        for(int i = 1; i <= len1; i++)
            for(int j = 1; j<= len2; j++){
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                cost = (a==b)?0:1;
                table[i][j] = Math.min(table[i - 1][j] + 1,
                Math.min(table[i][j-1] + 1, table[i-1][j-1] + cost));
            }
        return table[len1][len2];
    }
    
    //Will cause stack overflow
    public int naiveLevenshtein(String word1, String word2){
        int len1 = word1.length(), len2 = word2.length();
        int cost = 0;
        if(len1 == 0) return len2;
        else if(len2 == 0) return len1;
        else if(word1.charAt(0) != word2.charAt(0))
            cost = 1;
        return Math.min(naiveLevenshtein(word1.substring(1), word2) + 1,Math.min(
        naiveLevenshtein(word1, word2.substring(1)) + 1,
        naiveLevenshtein(word1.substring(1), word2.substring(1)) + cost));
    }
}