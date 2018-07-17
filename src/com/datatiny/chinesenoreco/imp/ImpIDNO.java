package com.datatiny.chinesenoreco.imp;

import com.datatiny.chinesenoreco.comm.IRecoChineseNo;

public class ImpIDNO implements IRecoChineseNo {
	private static String[] vercode;
	@Override
	public boolean isValid(String no) {
		if(no.length()!=18) return false;
		no=no.toLowerCase();
		String strverify=no.substring(17);
		String strpverify=getVerify(no.substring(0, 17));
		return strverify.equalsIgnoreCase(strpverify);
	}
	private static String getVerify(String substring) {
		String[] arnum=substring.split("");
		int sum=0;
		for(int i=0;i<arnum.length;i++) {
			int curnum=Integer.valueOf(arnum[i]);
			int weight=(int) Math.pow(2, 17-i) % 11;
			sum+=curnum *weight;
			
			
		}
		
		int mod=sum %11;
		return vercode[mod];
	}
	static {
		vercode=new String[] {"1","0","x","9","8","7","6","5","4","3","2"};
		
	}


}
