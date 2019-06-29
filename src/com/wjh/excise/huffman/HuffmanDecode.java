package com.wjh.excise.huffman;

import java.util.Map;

/**
 * ʹ���������ƥ�䣬�������ƥ�䲻��
 * @author Administrator
 *
 */
public class HuffmanDecode {
	public String decode(Map<Character, String> dictMap, String text) {
		if (text == null || text.trim().length() == 0)
			return null;
		String decode = "";

		// ����dictMap��k��v
		Map<String, Character> map = MapUtil.swapKV(dictMap);
		// ��ȡmap�����key
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
