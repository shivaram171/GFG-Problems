class Solution {
    public int minParentheses(String s) {
        int open = 0;  // count of unmatched '('
        int add = 0;   // count of unmatched ')'
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else { // ch == ')'
                if (open > 0) {
                    open--; // match with previous '('
                } else {
                    add++; // need an extra '('
                }
            }
        }
        
        // Remaining open '(' need matching ')'
        return open + add;
    }
}
 