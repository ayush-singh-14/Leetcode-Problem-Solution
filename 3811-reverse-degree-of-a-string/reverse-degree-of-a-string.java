class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int revAlphabetVal = 26 - (s.charAt(i) - 'a');
            int stringIndex = i + 1;
            
            total += revAlphabetVal * stringIndex;
        }
        return total;
    }
}