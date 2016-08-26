public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        Set<Character> set = new HashSet();
        List<Character> list = new ArrayList();
        set.add(s.charAt(0));
        list.add(s.charAt(0));
        count[s.charAt(0) - 'a']--;
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                count[c - 'a']--;
                continue;
            }
            
            char last = list.get(list.size() - 1);
            while(last > c && count[last - 'a'] > 0)
            {
                list.remove(list.size() - 1);
                set.remove(last);
                if (list.isEmpty()) {
                    break;
                }
                else {
                    last = list.get(list.size() - 1);
                }
            }
            
            list.add(c);
            set.add(c);
            count[c - 'a']--;
        }
        
        StringBuilder sb = new StringBuilder();
        for(Character c : list) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}