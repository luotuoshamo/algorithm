package com.wjh.excise.huffman;

import java.util.ArrayList;
import java.util.List;

public class CharacterPo implements Comparable {
	private Character character;// 字符
	private Integer number;// 字符个数
	private Boolean needEncode;// 在构造hfm tree时是否可以取出
	private CharacterPo parent;// 父节点
	private CharacterPo left;// 左节点
	private CharacterPo right;// 右节点
	private List<Integer> codeList;// 编码
	private Boolean leaf;// 是否是叶节点（是否是需要编码的节点）

	/* constructor */
	public CharacterPo(Character character, Integer number, Boolean needEncode) {
		this.character = character;
		this.number = number;
		this.needEncode = needEncode;
		this.parent = null;
		this.right = null;
		this.left = null;
		this.leaf = false;
		this.codeList = new ArrayList<Integer>();
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Boolean getNeedEncode() {
		return needEncode;
	}

	public void setNeedEncode(Boolean needEncode) {
		this.needEncode = needEncode;
	}

	public CharacterPo getParent() {
		return parent;
	}

	public void setParent(CharacterPo parent) {
		this.parent = parent;
	}

	public CharacterPo getLeft() {
		return left;
	}

	public void setLeft(CharacterPo left) {
		this.left = left;
	}

	public CharacterPo getRight() {
		return right;
	}

	public void setRight(CharacterPo right) {
		this.right = right;
	}

	public List<Integer> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<Integer> codeList) {
		this.codeList = codeList;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	@Override
	public String toString() {

		return "[" + character + ":" + number + "]";
	}

	public int compareTo(Object o) {
		if (o instanceof CharacterPo) {
			CharacterPo po = (CharacterPo) o;
			return this.number - po.number;
		}
		return 0;
	}

}
