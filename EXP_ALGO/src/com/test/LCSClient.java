package com.test;
import  com.lcs.*;

public class LCSClient {
	public static void main(String []args){

		//测试三个串		
		String x = CreateRandomStr.getRandomString(5);
		String y = CreateRandomStr.getRandomString(5);
		String z = CreateRandomStr.getRandomString(5);

		
		System.out.print(x + '\n' + y + '\n' + z + '\n');
		LCS.getLCS3(x, y, z);		
		
		//测试两个串
//		String x = CreateRandomStr.getRandomString(10);
//		String y = CreateRandomStr.getRandomString(10);
//		System.out.println(x);
//		System.out.println(y);	
//		long timeTestStart = System.currentTimeMillis();
//		LCS.getLCS2(x, y);
//		long timeTestEnd = System.currentTimeMillis();
//		
//		System.out.println("Time cost:" + (timeTestEnd - timeTestStart));
	}
}
