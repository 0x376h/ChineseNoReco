package com.datatiny.chinesenoreco.test;


import com.datatiny.chinesenoreco.comm.ChinseNoTypes;
import com.datatiny.chinesenoreco.comm.RecoChineseNoHelper;

public class doTestReco {
	public static void main(String[] args) {
		String creditno="91350100m000100y43";//from  GB 32100-2015
		String orgno="d2143569-x";//from GB 11714-1997
		String businesregno="110108000000016" ;//from GS15—2006
		String idnum="11010519491231002x"; //from GB 11643-1999
		
		System.out.println(RecoChineseNoHelper.isVaild(creditno,ChinseNoTypes.CREDITNO));
		System.out.println(RecoChineseNoHelper.isVaild(orgno,ChinseNoTypes.ORGNO));
		System.out.println(RecoChineseNoHelper.isVaild(businesregno,ChinseNoTypes.BUSINESREGNO));
		System.out.println(RecoChineseNoHelper.isVaild(idnum,ChinseNoTypes.IDNO));
	}
	
}
