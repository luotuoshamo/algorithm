package com.wjh.course;

import java.util.List;


/**
 * °£¼°·ÖÊý
 * @author Administrator
 *
 */
public class EgyptianScoreTest {
	public static void main(String[] args) {
		Fraction fraction = new Fraction(7, 5);
		List<Fraction> list = fraction.toEgyptianScore();
		System.out.println(list);

		// test methods in Fraction
		// System.out.println(fraction.equals2Zero());
		// System.out.println(fraction.compare(new Fraction(1, 1)));
		// System.out.println(fraction.sub(new Fraction(1, 2)));
	}
}
