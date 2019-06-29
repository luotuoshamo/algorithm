package com.wjh.excise.huffman.test;

import java.util.Map;

import com.wjh.excise.huffman.HuffmanDecode;
import com.wjh.excise.huffman.HuffmanEncode;

public class TestDecode_string {
	public static void main(String[] args) {
		String text = "aaaabbbccd";
		System.out.println("text��" + text);

		HuffmanDecode huffmanDecode = new HuffmanDecode();
		Map<Character, String> hfmDictMap = new HuffmanEncode()
				.getHfmDictMap(text);
		System.out.println("hfm dict��" + hfmDictMap);

		String encode = new HuffmanEncode().getNewText(text);
		System.out.println("after encoding��" + encode);

		String decode = huffmanDecode.decode(hfmDictMap, encode);
		System.out.println("after decoding��" + decode);
	}
}
