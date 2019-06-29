package com.wjh.excise.huffman.test;

import java.util.Arrays;

import org.junit.Test;

import com.wjh.excise.huffman.StatisticsUtil;

public class JTest {
	@Test
	public void testStatistic() {
		StatisticsUtil.showInGrid("aaaabbbccd");
	}

	@Test
	public void testBytes() throws Exception {
		String s = "aaaabbbccd";
		byte[] bytes = s.getBytes("utf-8");
		for (byte b : bytes) {
			System.out.print(b & 0xff);
			System.out.println((char) b);
		}
		System.out.println();
		System.out.println(-200 & 0xff);// 56
		System.out.println(-100 & 0xff);// 156
		System.out.println(200 & 0xff);// 200
		System.out.println(0 & 0xff);// 0
	}

	@Test
	public void testBase() throws Exception {
		// ISO8859-1 [63, 63, 63, 63, 63]
		// UTF-8 [-24, -123, -66, -24, -82, -81, -27, -100, -88, -26, -73, -79,
		// -27, -100, -77]
		// GBK [-52, -38, -47, -74, -44, -38, -55, -18, -37, -38]
		// GB2312 [-52, -38, -47, -74, -44, -38, -55, -18, -37, -38]
		String string = "ÌÚÑ¶ÔÚÉîÛÚ";
		String charSet = "";
		byte[] bytes = string.getBytes();
		System.out.println(Arrays.toString(bytes));

	}

}
