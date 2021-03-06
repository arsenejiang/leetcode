public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList();
        if (words == null || words.length < 2) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome(str1)) {
                    String reverse = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(reverse) && map.get(reverse) != i) {
                        List<Integer> list = new ArrayList();
                        list.add(map.get(reverse));
                        list.add(i);
                        res.add(list);
                    }
                }
                
                if (str2.length() != 0 && isPalindrome(str2)) {
                    String reverse = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(reverse) && map.get(reverse) != i) {
                        List<Integer> list = new ArrayList();
                        list.add(i);
                        list.add(map.get(reverse));
                        res.add(list);
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        
        return true;
    }
}