// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 

// 这道题目和前面那道题目基本一样，不过要考虑的东西要稍微多一点，即不能出现重复的数据。用到了hashset，因为hashset不接受重复的数据。

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);

        combinationSum2(candidates, target, 0, current, result);

        HashSet<List<Integer>> set=new HashSet<List<Integer>>(result);

        result.clear();
        result.addAll(set);

        return result;
    }

    public void combinationSum2(int[] candidates, int target, int j, ArrayList<Integer> curr, List<List<Integer>> result){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        for(int i=j; i<candidates.length; i++){
            if(target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i+1, curr, result);
            curr.remove(curr.size()-1);
        }

    }
}
