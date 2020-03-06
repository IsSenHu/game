package com.qdhh.game;

public final class XXTEAUtil {
	public static byte[] Decrypt(byte[] encryptedBytes, byte[] IV, byte[] KEY) {
		return XXTEA.decrypt(encryptedBytes, KEY);
	}
	
	public static byte[] Encrypt(byte[] plainBytes, byte[] IV, byte[] KEY) {
		return XXTEA.encrypt(plainBytes, KEY);
	}
}
