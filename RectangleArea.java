public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = Math.max(A, E) < Math.min(C, G) ? Math.min(C, G) - Math.max(A, E) : 0;
        int height = Math.max(B, F) < Math.min(D, H) ? Math.min(D, H) - Math.max(B, F) : 0;
        
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        return area1 + area2 - width * height;
    }
}
