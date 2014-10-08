package com.ooad.project.class_scheduler.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
	
	private MessageDigest md;
	
	public String encrypt(String str){
		String resultStr = "";
		try {
			byte[] strBytes = str.getBytes("UTF-8");
			md = MessageDigest.getInstance("MD5");
			resultStr = md.digest(strBytes).toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultStr;
	}
}
