package com.wjh.excise.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����������
 * @author Administrator
 *
 */
public class HuffmanEncode {

	/* �����ַ�ͳ����Ϣ��list������haffman tree's root */
	private CharacterPo getHuffmanTree(List<CharacterPo> list) {

		if (list == null || list.isEmpty())
			return null;
		CharacterPo root = null;
		Integer size = StatisticsUtil.getNeedEncodeSize(list);
		while (StatisticsUtil.getNeedEncodeSize(list) > 0) {

			// last time means only 2 nodes��s needEncode is true in the list
			boolean lastTime = false;

			if (StatisticsUtil.getNeedEncodeSize(list) == 2)
				lastTime = true;

			CharacterPo min1 = StatisticsUtil.extractMin(list);
			CharacterPo min2 = StatisticsUtil.extractMin(list);

			// ����������false��Ч��why��������ȡmin2ǰ����min1
			// ��needEncode=false
			// ���԰�����needEncode������extractMin������
			// ��������ʵ����
			// min1.setNeedEncode(false);
			// min2.setNeedEncode(false);

			CharacterPo p = new CharacterPo('#', min1.getNumber()
					+ min2.getNumber(), true);
			p.setLeft(min1);
			p.setRight(min2);
			min1.setParent(p);
			min2.setParent(p);

			// ��ֻ��2���ַ�ʱ-���һ��
			if (!lastTime)
				list.add(p);

			root = p;
		}

		return root;
	}

	/* ����huffman tree���б��� */
	private List<CharacterPo> huffmanEncode(List<CharacterPo> list) {
		// left:0 right:1
		for (CharacterPo po : list) {
			if (!po.getLeaf())
				continue;
			CharacterPo tmpPo = po;
			while (tmpPo.getParent() != null) {
				CharacterPo parent = tmpPo.getParent();
				Integer code = parent.getLeft() == tmpPo ? 0 : 1;
				po.getCodeList().add(code);

				tmpPo = tmpPo.getParent();
			}
		}
		for (CharacterPo po : list) {
			if (po.getLeaf()) {
				Collections.reverse(po.getCodeList());
			}
		}

		// ɸѡ����Ҫ����Ľڵ�
		ArrayList<CharacterPo> resList = new ArrayList<CharacterPo>();
		for (CharacterPo po : list) {
			if (po.getLeaf())
				resList.add(po);
		}
		return resList;
	}

	/*
	 * ��getHuffmanTree��huffmanEncode���� ����list��ʽ�ı����ֵ�
	 */
	public List<CharacterPo> getHfmDictList(String text) {
		List<CharacterPo> list = StatisticsUtil.text2Statistic(text);
		getHuffmanTree(list);
		return huffmanEncode(list);
	}

	/*
	 * ��getHuffmanTree��huffmanEncode���� ����map��ʽ�ı����ֵ�
	 */
	public Map<Character, String> getHfmDictMap(String text) {
		HashMap<Character, String> dictMap = new HashMap<Character, String>();
		List<CharacterPo> dictList = getHfmDictList(text);

		for (CharacterPo po : dictList) {
			String codeString = "";
			for (Integer code : po.getCodeList())
				codeString += code;

			dictMap.put(po.getCharacter(), codeString);
		}
		return dictMap;
	}

	/* ��huffman �����ת��text */
	public String getNewText(String text) {
		Map<Character, String> hfmDictMap = getHfmDictMap(text);
		String newText = "";
		for (int i = 0; i < text.length(); i++) {
			newText += hfmDictMap.get(text.charAt(i));
		}
		return newText;
	}

	/* �Ѷ����ƴ�ת�����ֽ����� */
	public byte[] string2ByteArray(String text) {

		return text.getBytes();
		// return null;
	}

	/* ����ѹ���� */
	public double getCompressionRadio(String oldText, String newText) {
		double newLen = Math.ceil(newText.length() / 8.0);
		int oldLen = oldText.length();
		// System.out.println("newLen=" + newLen + ",oldLen=" + oldLen);
		return 1 - newLen / oldLen;
	}
}
