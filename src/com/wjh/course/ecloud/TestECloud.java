package com.wjh.course.ecloud;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestECloud extends JFrame {

	public static void main(String[] args) {
		new TestECloud();
	}

	public TestECloud() {
		super("电子云");
		Container cp = this.getContentPane();
		cp.setBackground(Color.white);
		this.setLocation(200, 100);
		this.setSize(500, 500);
		this.setLayout(getLayout());// 设置窗口布局
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);// 加上这一句，窗体背景色就会画出来
		Graphics gr = g;
		gr.setColor(Color.black);
		// gr.fillOval(80, 80, 5, 5);

		// the first two args is the center of tracks
		new ECloud().drawCloud(200, 200, 10, 200, 1, g);
	}
}
