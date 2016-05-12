// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:
// For the return value, each inner list's elements must follow the lexicographic order.
// All inputs will be in lower-case.


// 这道题的意思是将相同的字母重复的放到一起，并且需要有序的输出。
// 这道题主要学习了hashmap的用法。把所有的相同的单词都放在同一个key包含的List<String>中。其中这个key通过转换每个单词并将其排序来实现。


import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result=new ArrayList<List<String>>();
        if(strs==null||strs.length==0) return result;
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);
            String temp=new String(chars);
            if(!map.containsKey(temp)){
                List<String> result_list=new ArrayList<>();
                result_list.add(strs[i]);
                map.put(temp,result_list);
            }else{
                map.get(temp).add(strs[i]);
            }
        }


        for(String key:map.keySet()){
            List<String> cur=map.get(key);
            Collections.sort(cur);
            result.add(cur);

        }



        return result;
    }

}