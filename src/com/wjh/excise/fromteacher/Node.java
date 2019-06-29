package com.wjh.excise.fromteacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node implements Comparable<Node> {
	public byte data;
	public int occ;
	public int total;
	public double probility;
	public String code;
	public Node left;
	public Node right;

	@Override
	public String toString() {
		return String.format("%c\t%d\t%d\t%.2f%%", (char) data, occ, total,
				probility);

	}

	public Node(Node left, Node right) {
		this.left = left;
		this.right = right;
		this.probility = left.probility + right.probility;
		left.code = "0";
		right.code = "1";
	}

	public Node(int data, int occ, int total) {
		this.data = (byte) data;
		this.occ = occ;
		this.total = total;
	}

	public static void show(List<Node> nodes) {
		System.out.println("Data\tOcc\tTotal\tProbility\tCode");
		for (Node node : nodes)
			System.out.println(node);
	}

	public static void main(String[] args) throws Exception {
		String s = "aaaabbbccd";
		// 转成二进制
		// 这样可以适应汉字等非英文字符
		// String的getBytes()方法是得到一个字符串的字节数组，但
		// 特别要注意的是，本方法将返回该操作系统默认的编码格式的字节数组。
		// 如果你在使用这个方法时不考虑这一点，你
		// 会发现在一个平台上运行良好的系统，放到另一台机器上会//产生意想不到的问题。
		byte[] data = s.getBytes();

		// 统计字符出现次数
		// 假设所有的字符都是单字节-共256种字符
		int[] occs = new int[256];
		for (byte b : data) {
			occs[b & 0xff]++;
			// System.out.println(b);
		}

		// 输出
		for (int i = 0; i < occs.length; i++) {
			if (occs[i] > 0) {
				System.out.printf("%c\t%d\t%d\t%.2f%%\n", (char) i, occs[i],
						data.length, 100.0 * occs[i] / data.length);
			}
		}

		// 生成节点列表
		ArrayList<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < occs.length; i++) {
			if (occs[i] > 0) {
				nodes.add(new Node(i, occs[i], data.length));
			}
		}
		// 生成哈夫曼树
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			nodes.add(new Node(nodes.get(0), nodes.get(1)));
			nodes.remove(0);
			nodes.remove(0);
		}

	}

	public int compareTo(Node other) {
		// TODO Auto-generated method stub
		// return 0;
		return other.probility == this.probility ? 0
				: (other.probility < this.probility ? 1 : -1);
	}

}
