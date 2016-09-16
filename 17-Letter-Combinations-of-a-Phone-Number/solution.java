public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        char[] arr = digits.toCharArray();
        helper(arr, 0, "", res, map);
        return res;
    }
    
    private void helper(char[] arr, int index, String path, List<String> res, HashMap<Character, String> map) {
        if (index == arr.length) {
            res.add(path);
            return;
        }
        
        String s = map.get(arr[index]);
        for(char c : s.toCharArray()) {
            helper(arr, index + 1, path + c, res, map);
        }
    }
}