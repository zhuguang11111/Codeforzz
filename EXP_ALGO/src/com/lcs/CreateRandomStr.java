package com.lcs;
import java.util.*;
public class CreateRandomStr {
	public static String getRandomString(int length){  //length表示生成字符串的长度
//		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdedfghijklmnopqrstuvwxyz0123456789";
		String base = "abc";

		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++){
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
