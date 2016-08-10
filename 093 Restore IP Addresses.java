/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

又是一道回溯法的题目。
*/

public class Solution {
    public List<String> restoreIpAddress(String s) {
        ArrayList res = new ArrayList();
        ArrayList list = new ArrayList();
        this.dfs(res, list, 0, s);
        return res;
    }

    public void dfs(List<String> res, List<String> list, int start, String s) {
        if(list.size() == 4) {
            if(start == s.length()) {
                StringBuffer var8 = new StringBuffer();
                Iterator var9 = list.iterator();

                while(var9.hasNext()) {
                    String temp1 = (String)var9.next();
                    var8.append(temp1);
                    var8.append(".");
                }

                var8.deleteCharAt(s.length() - 1);
                res.add(var8.toString());
            }
        } else {
            for(int i = start; i < s.length() && i <= start + 3; ++i) {
                String temp = s.substring(start, i + 1);
                if(this.isvalid(temp)) {
                    list.add(temp);
                    this.dfs(res, list, i + 1, s);
                    list.remove(list.size() - 1);
                }
            }

        }
    }

    public boolean isvalid(String s) {
        if(s.charAt(0) == 48) {
            return s.equals("0");
        } else {
            int digit = Integer.valueOf(s).intValue();
            return digit >= 0 && digit <= 255;
        }
    }
}