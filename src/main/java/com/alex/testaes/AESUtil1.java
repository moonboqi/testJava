/**
 * 
 */
package com.alex.testaes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**  
* Title: AESUtil1  
* Description:   
* @author wangi  
* @date 2018年4月11日  
*/
public class AESUtil1 {
	/**
	 * 加密
	 *
	 * @param content  需要加密的内容
	 * @param password 加密密码
	 * @return
	 */
	public static byte[] encrypt(String content, String password) {
	    KeyGenerator kgen = null;
	    try {
	        kgen = KeyGenerator.getInstance("AES");
	        kgen.init(128, new SecureRandom(password.getBytes()));
	        SecretKey secretKey = kgen.generateKey();
	        byte[] enCodeFormat = secretKey.getEncoded();
	        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
	        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
	        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
	        byte[] byteContent = content.getBytes("utf-8");
	        byte[] result = cipher.doFinal(byteContent);
	        return result;//加密
	    } catch (NoSuchAlgorithmException | InvalidKeyException
	            | NoSuchPaddingException | BadPaddingException
	            | UnsupportedEncodingException | IllegalBlockSizeException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	/**
	 * 解密
	 *
	 * @param content  待解密内容
	 * @param password 解密密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] content, String password) {
	    KeyGenerator kgen = null;
	    try {
	        kgen = KeyGenerator.getInstance("AES");
	        kgen.init(128, new SecureRandom(password.getBytes()));
	        SecretKey secretKey = kgen.generateKey();
	        byte[] enCodeFormat = secretKey.getEncoded();
	        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
	        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
	        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
	        byte[] result = cipher.doFinal(content);
	        return result; // 解密
	    } catch (NoSuchAlgorithmException | BadPaddingException
	            | IllegalBlockSizeException | NoSuchPaddingException
	            | InvalidKeyException e) {
	        e.printStackTrace();
	    }
	    return null;

	}
	public static void main(String[] args) {
		String content = "test";
		String password = "123456";
		//加密
		System.out.println("加密前：" + content);
		byte[] encryptResult = encrypt(content, password);
		System.out.println("加密后：" + encryptResult.toString());
		//解密
		byte[] decryptResult = decrypt(encryptResult, password);
		System.out.println("解密后：" + new String(decryptResult));
	}
}
