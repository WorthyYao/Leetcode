/*
006 ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"

求zigzag转换字符串
 */

package leetcode;

public class Solution {
	public static String convert(String s, int numRows) {
		if(numRows==1 ) return s;
		int step=numRows*2-2,len=s.length();
		String ret="";
		
		//当判断第一行的时候，每次加的是step值，即numRows*2-2
		for(int i=0;i<len;i+=step){
			ret+=s.charAt(i);
		}
		
		//判断中间的行数的时候，除了每次增加的step的值以外，还有要判断是否加上j+(step-i*2)的值
		for(int i=1;i<numRows-1;i++){
			for(int j=i;j<len;j+=step){
				ret+=s.charAt(j);
				if(j+(step-i*2)<len)
					ret+=s.charAt(j+(step-i*2));
			}
		}
		
		//判断最后一行的时候，也是依次增加的
		for(int i=numRows-1;i<len;i+=step){
			ret+=s.charAt(i);
		}
		
		
		
		
		//System.out.println(s);
        return ret;
    }
	
	public static void main(String[] args) {
		String s="hello";
		convert(s,3);
	}
}
