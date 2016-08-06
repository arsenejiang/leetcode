public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // totalArea = area1 + area2 - overlap
        int area = (C - A) * (D - B) + (G - E) * (H - F); // area1 + area2
        
        // overlap
        // bottom left (I, J)
        // top right (K, L)
        int I = Math.max(A, E);
        int J = Math.max(B, F);
        int K = Math.min(C, G);
        int L = Math.min(D, H);
        
        // overlap exists
        if (K > I && L > J) {
            area -= (K - I) * (L - J);
        }
        
        return area;
    }
}