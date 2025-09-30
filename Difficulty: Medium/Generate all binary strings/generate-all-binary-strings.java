import java.util.ArrayList;

class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        // Start the recursive generation with an empty string
        generateBinaryStrings(n, "", result);
        return result;
    }

    private void generateBinaryStrings(int n, String currentString, ArrayList<String> result) {
        // Base case: If the current string has reached the desired length
        if (currentString.length() == n) {
            result.add(currentString);
            return;
        }

        // Recursive step: Append '0' and call the function again
        generateBinaryStrings(n, currentString + "0", result);

        // Recursive step: Append '1' and call the function again
        generateBinaryStrings(n, currentString + "1", result);
    }
}