public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int totalArea = (C - A) * (D - B) + (G - E) * (H - F);
        int I = Math.max(A, E);
        int J = Math.max(B, F);
        int K = Math.max(C, G);
        int L = Math.max(D, H);
        if (k > I && L > J) {
            totalArea -= (K - I) * (L - J);
        }
        
        return totalArea;
        
    }
}