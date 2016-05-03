// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

// 和前一题基本类似，不过增加了一个要求是去除掉所有重复的数据。这个要求前面的第40题里面做过。
// 就是多一个hashset这样可以去除掉重复的元素。其他的思想和前面一题基本差不多。

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //定义一个result存储数据
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        //将数组中的数据全都遍历插入进去
        for(int i=0;i<nums.length;i++){

            List<List<Integer>>  current=new ArrayList<List<Integer>>();

            for(List<Integer> l:result){
                for(int j=0;j<l.size()+1;j++){
                    l.add(j,nums[i]);
                    List<Integer> tmp=new ArrayList<Integer>(l);
                    current.add(tmp);
                    l.remove(j);
                }
            }

            result=new ArrayList<List<Integer>>(current);
        }
        //接下来的三行是为了去掉重复的集合。用的是hashset        
        HashSet<List<Integer>>  set=new HashSet<List<Integer>>(result);

        result.clear();

        result.addAll(set);

        return result;
    }
}
