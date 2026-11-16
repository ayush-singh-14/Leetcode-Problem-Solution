class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int unmatched = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '[') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    unmatched++;
                }
            }
        }
        return (unmatched + 1) / 2;
    }
}