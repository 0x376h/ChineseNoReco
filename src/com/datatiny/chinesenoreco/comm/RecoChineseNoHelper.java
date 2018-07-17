package com.datatiny.chinesenoreco.comm;

import com.datatiny.chinesenoreco.imp.ImpBUSINESREGNOHelper;
import com.datatiny.chinesenoreco.imp.ImpCreditNoHelper;
import com.datatiny.chinesenoreco.imp.ImpIDNO;
import com.datatiny.chinesenoreco.imp.ImpOrgNoHelper;

public class RecoChineseNoHelper {

	public static boolean isVaild(String no, ChinseNoTypes notype) {
		IRecoChineseNo recoChineseNo=getImpByType(notype);
		return recoChineseNo.isValid(no);
	}

	private static IRecoChineseNo getImpByType(ChinseNoTypes notype) {
		IRecoChineseNo ret=null;
		switch (notype) {
		case CREDITNO:
			ret= new ImpCreditNoHelper();
			break;
		case ORGNO:
			ret=new ImpOrgNoHelper();
			break;
		case BUSINESREGNO:
			ret=new ImpBUSINESREGNOHelper();
			break;
		case IDNO:
			ret =new ImpIDNO();
			break;
		default:
			break;
		}
		return ret;
	}

}
