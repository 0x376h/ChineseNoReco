package com.datatiny.chinesenoreco.imp;

import java.util.HashMap;

import com.datatiny.chinesenoreco.comm.IRecoChineseNo;

public class ImpCreditNoHelper implements IRecoChineseNo {
	private static HashMap<String, Integer> charnums=new HashMap<String, Integer>();
	private static String[] nums;
	@Override
	public boolean isValid(String no) {
		if(no.length()!=18) return false;
		no=no.toLowerCase();
		String vno=getverifycode(no.substring(0, 17));
		return vno.equalsIgnoreCase(no.substring(17));
		
	}

private static String getverifycode(String substring) {
	int sum=0;
	for(int i=0;i<17;i++) {
		int posnum=getPosNum(substring.substring(i, i+1));
		int weight=getWeight(i);
		
		sum+=(posnum*weight); 
		
	}
	int w1=sum % 31;
	if(w1==0) return "0";
	int vno=31-w1;
	String num=String.valueOf(vno);
	if(vno>=10) {
		vno=vno-10;
		num=nums[vno];
		//num=String.valueOf((char)(87+Integer.valueOf(num)));
	}
	return num;
	
}

public static int getWeight(int i) {
	return  (int) (Math.pow(3, i) % 31);
}

public static int getPosNum(String substring) {
	int num=substring.charAt(0);
	if(num <=57) return num-48;
	return charnums.get(substring);
}

static {
	nums="abcdefghjklmnpqrtuwxy".split("");
	load2Kw();
}

private static void load2Kw() {
	for(int i=0;i<nums.length;i++) {
		charnums.put(nums[i], i+10);
	}
	
}

}
