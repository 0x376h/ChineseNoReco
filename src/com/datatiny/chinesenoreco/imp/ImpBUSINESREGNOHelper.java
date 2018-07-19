package com.datatiny.chinesenoreco.imp;

import com.datatiny.chinesenoreco.comm.IRecoChineseNo;
//GS15—2006
public class ImpBUSINESREGNOHelper implements IRecoChineseNo {

	@Override
	public boolean isValid(String no) {
		if(no.length()!=15) return false;
		int verifyno=Integer.valueOf(no.substring(14));
		int pendingno=getPendingNo(no.substring(0, 14));
		return (pendingno+verifyno)%10 ==1;
	}
	private static int getPendingNo(String substring) {
		int pnum=10;
		String[] arnum=substring.split("");
		for(int i=0;i<arnum.length;i++) {
			int curnum=Integer.valueOf(arnum[i]);
			int snum=curnum+pnum;
			int snum10 =snum % 10;
			if(snum10==0) snum10=10;
			int ppnum=snum10*2;
			pnum=ppnum % 11;
			//System.out.println(pnum);
			
			
			
		}
		return pnum;
	}
}
