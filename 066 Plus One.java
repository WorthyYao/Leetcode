/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

给定一个用数组表示的一个数，对它进行加一操作。 
每一个数位都存储在数组的一个位置上。数组下标从大到小表示数位从低位到高位。 
应该是不是太难的，主要考虑的是最后一位的进位问题

*/

public int[] plusOne(int[] digits) {
        int num=1,temp;
        for(int i=digits.length-1;i>=0;i--){
            temp=digits[i]+num;
            digits[i]=temp%10;
            num=temp/10;
            if(num==0){
                break;
            }
        }
        if(num==1){
            int[] result=new int[digits.length+1];
            System.arraycopy(digits,0,result,1,digits.length);
            result[0]=num;
            return result;
        }else {
            return digits;
        }
    }
}