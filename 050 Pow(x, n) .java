// Implement pow(x, n).

// 这道题目是为了求一个数的幂次方。本来是用的递归，结果报了时间复杂度不行的问题。
// 后来改用了二分法来做。时间复杂度从o(n)降到了log(n)。
// 再后来，又给我报了一个边界问题。主要是Integer.Min_Value问题。


public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            //溢出边界问题
            if (n == Integer.MIN_VALUE) {
                return 1.0/ (pow(x, Integer.MAX_VALUE)*x);
            } else {
                return 1.0/ pow(x,n);
            }
        } else {
            return pow(x, n);
        }
    }

    public double pow(double x,int n){
        if(n==0){
            return 1;
        }
        else{
            double temp=pow(x,n/2);
            if(n%2==0){
                return temp*temp;
            }else{
                return temp*temp*x;
            }

        }
    }


}