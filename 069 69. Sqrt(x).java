/*
Implement int sqrt(int x).

Compute and return the square root of x.

计算x的平方根。题目难度还好，有两个问题。第一个是普通的遍历的话时间是不够用的，二分法来做。

第二是注意题目给的是int型，做的时候要注意溢出的问题。所以用了long型。

*/

public class Solution {
    public int mySqrt(int x) {
        long start=1,end=x;
        while (start+1<end){
            long mid=start+(end-start)/2;
            if(mid*mid<=x){
                start=mid;
            }else {
                end=mid;
            }
        }
        if(end*end<=x){
            return (int)end;
        }
        return (int)start;
    }
}