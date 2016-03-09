/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 *
 * 将罗马数字转换成整数。
 * 该题难度不大，模拟后得到该题答案
 */


public class Soulution {
	private int[] val=new int[255];
	private void init(){
		val['I']=1;val['V']=5;val['X']=10;
		val['L']=50;val['C']=100;val['D']=500;val['M']=1000;
	}
	
	public int romanToInt(String s){
		init();
		int ret=0;
		for(int i=0;i<s.length();i++){
			if(i>0&&val[s.charAt(i)]>val[s.charAt(i-1)]){
				ret+=val[s.charAt(i)]-2*val[s.charAt(i-1)];
			}else{
				ret+=val[s.charAt(i)];
			}
		}
		return ret;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soulution ss=new Soulution();
		System.out.println(ss.romanToInt("CCLV"));

	}

}
