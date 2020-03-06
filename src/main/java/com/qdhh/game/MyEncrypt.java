package com.qdhh.game;

public class MyEncrypt {

	/**
	 * 生成客户端机器身份验证码
	 * @param identifier
	 * @param iv
	 */
	public static byte[] GenCertif(String identifier, byte[] iv) throws Exception{
		String str = identifier + "1315Xx$";
		byte[] idbytes = str.getBytes();
		byte[] newB = new byte[iv.length + idbytes.length];
		System.arraycopy(idbytes, 0, newB, 0, idbytes.length);
		System.arraycopy(iv, 0, newB, idbytes.length, iv.length);
		return MyMD5Util.Md5_16(newB);
	}
	
	
}
