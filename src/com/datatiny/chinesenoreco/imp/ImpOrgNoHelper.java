package com.datatiny.chinesenoreco.imp;

import com.datatiny.chinesenoreco.comm.IRecoChineseNo;
//GB11714-1997
public class ImpOrgNoHelper implements IRecoChineseNo {
	private static int[] weigths;
	@Override
	public boolean isValid(String no) {
		no=no.replace("-", "");
		if(no.length()!=9) return false;
		no=no.toLowerCase();
		String vno=geVerifyNo(no.substring(0, 8));
		return vno.equalsIgnoreCase(no.substring(8));
	}
	private static String geVerifyNo(String substring) {
		int num=0;
		String[] nos=substring.split("");
		for(int i=0;i<nos.length;i++) {
			int curnum=getNum(nos[i]);
			num += (curnum * weigths[i]);			
		}
		int snum=num % 11;
		snum=11-snum;
		if(snum ==10) return "x";
		if(snum ==11) return "0";

		
		return String.valueOf(snum);
	}

	private static int getNum(String string) {
		int  num=string.codePointAt(0);
		if(num <=57) return num-48;
		return num-87;
	}

	static {
		weigths=new int[] {3,7,9,10,5,8,4,2};
	}

}
