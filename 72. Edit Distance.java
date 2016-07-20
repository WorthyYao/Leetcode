/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

这又是一道求动态规划的问题，不过感觉这道题的难度比前面几道要难不少，主要是感觉这个规律不太好分析出来。


据百度百科介绍：

编辑距离，又称Levenshtein距离（也叫做Edit Distance），是指两个字串之间，由一个转成另一个所需的最少编辑操作次数，如果它们的距离越大，说明它们越是不同。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。

　　例如将kitten一字转成sitting：

　　sitten （k→s）

　　sittin （e→i）

　　sitting （→g）

　　俄罗斯科学家Vladimir Levenshtein在1965年提出这个概念。因此也叫Levenshtein Distance。

例如

如果str1="ivan"，str2="ivan"，那么经过计算后等于 0。没有经过转换。相似度=1-0/Math.Max(str1.length,str2.length)=1
如果str1="ivan1"，str2="ivan2"，那么经过计算后等于1。str1的"1"转换"2"，转换了一个字符，所以距离是1，相似度=1-1/Math.Max(str1.length,str2.length)=0.8
应用
　　DNA分析

　　拼字检查

　　语音辨识

　　抄袭侦测

感谢大石头在评论中给出一个很好的关于此方法应用的连接 补充在此：

小规模的字符串近似搜索，需求类似于搜索引擎中输入关键字，出现类似的结果列表，文章连接:【算法】字符串近似搜索

算法过程

str1或str2的长度为0返回另一个字符串的长度。 if(str1.length==0) return str2.length; if(str2.length==0) return str1.length;
初始化(n+1)*(m+1)的矩阵d，并让第一行和列的值从0开始增长。
扫描两字符串（n*m级的），如果：str1[i] == str2[j]，用temp记录它，为0。否则temp记为1。然后在矩阵d[i,j]赋于d[i-1,j]+1 、d[i,j-1]+1、d[i-1,j-1]+temp三者的最小值。
扫描完后，返回矩阵的最后一个值d[n][m]即是它们的距离。
计算相似度公式：1-它们的距离/两个字符串长度的最大值。

*/



public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i< m+1; i++){
            dp[0][i] = i; 
        }
        for(int i=0; i<n+1; i++){
            dp[i][0] = i;
        }
        
        for(int i = 1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}