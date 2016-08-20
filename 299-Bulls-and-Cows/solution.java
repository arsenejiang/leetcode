public class Solution {
    public String getHint(String secret, String guess) {
        int[] counts = new int[10];
        int A = 0, B = 0;
        for(int i = 0; i < secret.length(); i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if (s == g) {
                A++;
            }
            else {
                if (counts[s - '0']-- > 0) {
                    B++;
                }
                
                if (counts[g - '0']++ < 0) {
                    B++;
                }
            }
        }
        
        return A + "A" + B + "B";
    }
}