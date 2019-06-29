package com.wjh.excise.huffman.test;

import java.util.Arrays;
import java.util.Map;

import com.wjh.excise.huffman.HuffmanEncode;

public class TestEncode_string {
	public static void main(String[] args) {
		String text = "aaaabbbccd";
		HuffmanEncode haffmanEncode = new HuffmanEncode();
		Map<Character, String> hfmDictMap = haffmanEncode.getHfmDictMap(text);
		System.out.println("hfm dict��" + hfmDictMap);
		String newText = haffmanEncode.getNewText(text);
		System.out.println("after encoding��" + newText);
		System.out.printf("compression radio��%.2f",
				haffmanEncode.getCompressionRadio(text, newText));

		System.out.println();
		System.out.println(Arrays.toString(haffmanEncode
				.string2ByteArray(newText)));

	}
}
