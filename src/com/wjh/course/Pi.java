package com.wjh.course;

public class Pi {
	public static void main(String[] args) {
		// 多次取平均
		double all = 0.0;
		int N = 10000;
		for (int i = 0; i < N; i++) {
			double pi = calculatePi();
			all += pi;
		}
		// 3.141681399999954
		System.out.println("after,pi=" + all / N);
	}

	/* 用概率计算pi，1/4个圆 */
	static double calculatePi() {
		int testTimes = 10000;

		int hitTimes = 0;
		for (int i = 1; i <= testTimes; i++) {
			double x = Math.random();
			double y = Math.random();
			// System.out.println("x=" + x + "y=" + y);
			if (x * x + y * y < 1)
				hitTimes++;
		}

		// System.out.println("hitTimes=" + hitTimes);
		double pi = 4.0 * hitTimes / testTimes;
		System.out.println("pi=" + pi);
		return pi;
	}
}
