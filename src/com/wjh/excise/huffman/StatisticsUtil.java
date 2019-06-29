package com.wjh.excise.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticsUtil {

	private StatisticsUtil() {
	}

	/*
	 * 输入一个文本，输出该文本的字符统计信息的
	 * 
	 * @return 用map表示统计信息
	 */
	private static Map<Character, Integer> text2Map(String text) {
		if (text == null || "".equals(text.trim()))
			return null;

		Map<Character, Integer> map = new TreeMap<Character, Integer>();

		for (int i = 0; i < text.length(); i++) {
			if (map.containsKey(text.charAt(i))) {
				map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
			} else {
				map.put(text.charAt(i), 1);
			}
		}
		return map;
	}

	/* 把k-v pair装成对象放入list中 */
	private static List<CharacterPo> map2POList(Map<Character, Integer> map) {
		// System.out.println(map);
		ArrayList<CharacterPo> list = new ArrayList<CharacterPo>();
		for (Character c : map.keySet()) {
			CharacterPo characterPo = new CharacterPo(c, map.get(c), true);
			characterPo.setLeaf(true);
			CharacterPo po = characterPo;
			list.add(po);
		}
		return list;
	}

	/* 对text2Map和map2POList整合 */
	public static List<CharacterPo> text2Statistic(String text) {
		Map<Character, Integer> map = text2Map(text);
		return map2POList(map);
	}

	/* 从list中取出最小的 */
	public static CharacterPo extractMin(List<CharacterPo> list) {
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNeedEncode()) {
				list.get(i).setNeedEncode(false);
				return list.get(i);
			}
		}
		return null;
	}

	/* 获取list中需要编码的节点的个数 */
	public static Integer getNeedEncodeSize(List<CharacterPo> list) {
		int size = 0;
		for (CharacterPo po : list) {
			if (po.getNeedEncode())
				size++;
		}

		return size;
	}

	/* 用表格显示统计信息 */
	public static void showInGrid(String text) {
		System.out.println("data\t occ\t total\t properbility\t");
		List<CharacterPo> list = text2Statistic(text);
		for (CharacterPo po : list) {
			// 计算字符出现的概率
			double pro = 1.0 * po.getNumber() / text.length();
			// System.out.println(pro);
			System.out.println(po.getCharacter() + "\t " + po.getNumber()
					+ "\t " + text.length() + "\t " + pro * 100 + "%");
		}
	}
}
