package com.ooad.project.class_scheduler.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptUtil {
	
	private MessageDigest md;
	
	public String encrypt(String str){
		
		StringBuilder sb = new StringBuilder();
		@SuppressWarnings("unused")
		byte[] strBytes;
		
		try {
			strBytes = str.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			
			byte[] digest = md.digest();
			
			for(byte b:digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
	public String generateBase64(String str) {
		return new String(Base64.getEncoder().encode(str.getBytes()));
	}
	
	public String deceodeBase64(String str) {
		return new String(Base64.getDecoder().decode(str.getBytes()));
	}
}
