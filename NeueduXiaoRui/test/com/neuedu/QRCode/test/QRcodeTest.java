package com.neuedu.QRCode.test;

import org.junit.Test;

import com.neuedu.XiaoRyi.Util.QRCodeUtil;

public class QRcodeTest {
	
	@Test
	public void qrcodetest2() {
		String content="http://10.25.194.67:8088/NeueduXiaoRui/Neu_Emp_Login.html";
		String path="WebContent/update";
		
		try {
			QRCodeUtil.encode(content,null,path,false,"4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void qrcodetest1() {
		String content="世界你好!";
		String path="update";
		
		try {
			QRCodeUtil.encode(content,null,path,false,"18");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
