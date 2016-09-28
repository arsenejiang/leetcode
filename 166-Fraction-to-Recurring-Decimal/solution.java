public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num / den);
        long reminder = num % den;
        if (reminder == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        map.put(reminder, sb.length());
        while(reminder != 0) {
            reminder = reminder * 10;
            sb.append(reminder / den);
            reminder = reminder % den;
            if (map.containsKey(reminder)) {
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            }
            else {
                map.put(reminder, sb.length());
            }
        }
        
        return sb.toString();
    }
}