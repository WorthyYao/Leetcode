/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int number=0;
        int count=0;
        for (int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                count++;
                if(count>=3){
                    continue;
                }
            }
            else {
                count=1;
            }
            nums[number++]=nums[i];
        }
        return number;
    }
}