/**
 * Integer to Roman
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * 将1到3999之间的任意整数转换成罗马数字
 *
 * 本题难度还好，主要是熟悉罗马数字的表示方法之后，将常用数字转换过来
 * 熟悉了StringBuilder,String，StringBuffer三个类 的区别，以及toString的作用
 */
public class Soulution {
	private int[] val={
			1000,900,500,400,100,90,50,40,10,9,5,4,1
	};
	   
	private String[] syb={
			"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"
	};    
	
	public String intToRoman(int num){
		StringBuilder roman=new StringBuilder();
		int i=0,j;
		//一段循环将阿拉伯数字循环转换成罗马数字
		while(num>0){
			j=num/val[i];
			while(j-->0){
				roman.append(syb[i]);
				num-=val[i];
			}
			i++;
		}
		return roman.toString();
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soulution ss=new Soulution();
		ss.intToRoman(3999);
	}

}
