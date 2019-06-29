package com.wjh.excise.huffman;

import java.util.Map;

/**
 * 使用正向最大匹配，逆向最大匹配不行
 * @author Administrator
 *
 */
public class HuffmanDecode {
	public String decode(Map<Character, String> dictMap, String text) {
		if (text == null || text.trim().length() == 0)
			return null;
		String decode = "";

		// 调换dictMap的k，v
		Map<String, Character> map = MapUtil.swapKV(dictMap);
		// 获取map中最长的key
		String longestKey = MapUtil.getLongestKey(map);

		int i = 0;
		int len = Math.min(longestKey.length(), text.length());
		while (i < text.length()) {
			String s = text.substring(i, i + len);
			Character character = map.get(s);
			if (character == null)
				len--;
			else {
				decode += character;
				i += len;
				len = Math.min(longestKey.length(), text.length() - i);
			}

		}
		return decode;

	}
}
