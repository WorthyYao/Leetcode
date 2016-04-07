// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.



public class Solution {
    public String countAndSay(int n) {

        String result = "1";
        for (int i = 2; i <=n ; i++) {
            result = countAndSay(result);
        }

        return result;
    }

    public String countAndSay(String str) {
        StringBuilder builder = new StringBuilder(128);

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                builder.append(count);
                builder.append(str.charAt(i - 1));
                count = 1;
            }
        }

        builder.append(count);
        builder.append(str.charAt(str.length() - 1));
        return builder.toString();
    }
}