package com.wjh.excise.huffman;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	// private MapUtil() {
	// }
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("name", 1);
		map.put("age", 22);
		Map<Integer, String> m = swapKV(map);
		System.out.println(m);
		System.out.println(getLongestKey(map));
	}

	/* 返回一个**新**的map，k是原来的v，v是原来的k */
	public static <T1, T2> Map<T2, T1> swapKV(Map<T1, T2> map) {
		HashMap<T2, T1> m = new HashMap<T2, T1>();
		for (T1 k : map.keySet()) {
			m.put(map.get(k), k);
		}
		return m;
	}

	/* 获取长度最大的k */
	static String getLongestKey(Map map) {
		String res = "";

		for (Object key : map.keySet()) {
			String k = null;
			if (key instanceof String)
				k = (String) key;
			if (k.length() > res.length())
				res = k;
		}
		return res;
	}
}
