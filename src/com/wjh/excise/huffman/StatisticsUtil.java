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
	 * ����һ���ı���������ı����ַ�ͳ����Ϣ��
	 * 
	 * @return ��map��ʾͳ����Ϣ
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

	/* ��k-v pairװ�ɶ������list�� */
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

	/* ��text2Map��map2POList���� */
	public static List<CharacterPo> text2Statistic(String text) {
		Map<Character, Integer> map = text2Map(text);
		return map2POList(map);
	}

	/* ��list��ȡ����С�� */
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

	/* ��ȡlist����Ҫ����Ľڵ�ĸ��� */
	public static Integer getNeedEncodeSize(List<CharacterPo> list) {
		int size = 0;
		for (CharacterPo po : list) {
			if (po.getNeedEncode())
				size++;
		}

		return size;
	}

	/* �ñ����ʾͳ����Ϣ */
	public static void showInGrid(String text) {
		System.out.println("data\t occ\t total\t properbility\t");
		List<CharacterPo> list = text2Statistic(text);
		for (CharacterPo po : list) {
			// �����ַ����ֵĸ���
			double pro = 1.0 * po.getNumber() / text.length();
			// System.out.println(pro);
			System.out.println(po.getCharacter() + "\t " + po.getNumber()
					+ "\t " + text.length() + "\t " + pro * 100 + "%");
		}
	}
}
