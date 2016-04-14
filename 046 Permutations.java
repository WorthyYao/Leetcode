// Given a collection of distinct numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


//求给出一个数组的情况下，求出这个数组的所有排列组合并返回。其中所给的数组没有重复数字
//可以通过依次添加来算得所有的，如下所示，复杂度为n三次方

// [1]
// [2, 1]
// [1, 2]
// [3, 2, 1]
// [2, 3, 1]
// [2, 1, 3]
// [3, 1, 2]
// [1, 3, 2]
// [1, 2, 3]



package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());

        for(int i=0;i<nums.length;i++){
            List<List<Integer>> current=new ArrayList<List<Integer>>();

            for(List<Integer> l : result){
                for(int j=0;j<l.size()+1;j++){
                    l.add(j,nums[i]);
                    List<Integer> tmp=new ArrayList<Integer>(l);

                    current.add(tmp);

                    l.remove(j);

                }
            }
            result =new ArrayList<List<Integer>>(current);
        }
        return result;

    }
}
