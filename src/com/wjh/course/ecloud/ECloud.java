package com.wjh.course.ecloud;

import java.awt.Graphics;

public class ECloud {
	/* �뾶Ϊr�Ĺ������number(r)������ */
	/* y=5000/x */
	int number(int r) {
		// return (int) (Math.pow(0.5, r - 11.0));
		return (int) (5000 / r);
	}

	/* �ڰ뾶Ϊr�Ĺ���ϻ�number(r)������ */
	void drawTrack(int c_x, int c_y, int r, Graphics g) {
		int number = number(r);
		for (int i = 0; i < number; i++) {
			int x = (int) (Math.random() * (r + r) - r);
			int y = (int) (Math.random() * (r + r) - r);
			while (!(x * x + y * y < r * r)) {
				x = (int) (Math.random() * (r + r) - r);
				y = (int) (Math.random() * (r + r) - r);
			}
			System.out.println("draw:x=" + x + ",y=" + y);

			// draw an electron
			g.fillOval(x + c_x, y + c_y, 2, 2);
		}
	}

	/*
	 * �����������ƣ������ΧrFrom-rTo �������step,
	 * 
	 * @param c_x��c_y�ǹ�����ĵ�����
	 */
	void drawCloud(int c_x, int c_y, int rFrom, int rTo, int step, Graphics g) {
		for (int r = rFrom; r < rTo; r += step) {
			drawTrack(c_x, c_y, r, g);
		}
	}
}
