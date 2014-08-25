package com.caoyt.framework.utils;


/**
 * @author caoyt(曹颖桐)
 * @email caoyingtong@41zone.cc
 * @date 2014-8-20 上午09:35:30
 * 
 * UID
 */
public class UID {
	public static String randomUUID(){
		return java.util.UUID.randomUUID().toString().replace('-', '0');
	}
}
