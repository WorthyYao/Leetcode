/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

这道题和46,47题都很有关系的，但是那两道题目都是一个个的插入进去来做的。这道题目如果先排好序再来做的话，时间复杂度是o(n3)，明显是不可以的。

如果换用别的思路的话，可以发现的是如果给的是n个数，那么会有的是n！个组合。而第一个数是有(n-1)!个可能的。依次往下类推下去，
可以得出这道题的解决办法。另外一点是用arraylist来保存数字，当这些数字被用过以后，就从arraylist中除掉。
Note: Given n will be between 1 and 9 inclusive.
*/
public class Solution {
    public String getPermutation(int n, int k) {
        String res="";
        ArrayList<Integer> number=new ArrayList<>();
        for(int i=1;i<=n;i++){
            number.add(i);
        }

        k--;

        int temp=1;
        for(int i=1;i<=n;i++){
            temp=temp*i;
        }

        for (int i=0;i<n;i++){
            temp=temp/(n-i);
            int index=k/temp;
            k=k%temp;


            res=res+number.get(index);

            number.remove(index);

        }

        return res.toString();
    }
}