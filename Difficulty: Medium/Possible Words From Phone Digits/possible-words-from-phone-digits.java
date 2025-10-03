import java.util.*;

class Solution {
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        backtrack(arr, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int[] arr, int index, StringBuilder path, ArrayList<String> result) {
        if (index == arr.length) {
            // only add non-empty words (skip case where all digits were 0/1)
            if (path.length() > 0) result.add(path.toString());
            return;
        }

        String letters = KEYPAD[arr[index]];
        if (letters == null || letters.length() == 0) {
            // skip digits that don't map to letters (0 or 1)
            backtrack(arr, index + 1, path, result);
            return;
        }

        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(arr, index + 1, path, result);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }

    // Optional quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {8, 8, 1};
        System.out.println(s.possibleWords(arr)); // [tt, tu, tv, ut, uu, uv, vt, vu, vv]
    }
}
