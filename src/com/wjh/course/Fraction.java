package com.wjh.course;

import java.util.ArrayList;
import java.util.List;

/**
 * ����
 * @author Administrator
 *
 */
public class Fraction {
	private Integer numerator;// ����
	private Integer denominator;// ��ĸ

	/* allArgsConstactor */
	public Fraction(Integer numerator, Integer denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/* toString */
	@Override
	public String toString() {
		// return "Fraction [numerator=" + numerator + ", denominator="
		// + denominator + "]";
		return numerator + "/" + denominator;
	}

	public Integer getNumerator() {
		return numerator;
	}

	public void setNumerator(Integer numerator) {
		this.numerator = numerator;
	}

	public Integer getDenominator() {
		return denominator;
	}

	public void setDenominator(Integer denominator) {
		this.denominator = denominator;
	}

	/* �ѵ�ǰ����ת���ɰ������� */
	public List<Fraction> toEgyptianScore() {
		List<Fraction> resList = new ArrayList<Fraction>();

		int de = 2;
		while (!this.equals2Zero()) {
			Fraction f = new Fraction(1, de);
			if (this.compare(f) == 1) {
				resList.add(f);
				de++;
				this.sub(f);
			} else if (this.compare(f) == 0) {
				resList.add(f);
				return resList;
			} else {
				de++;
			}
		}
		return resList;
	}

	/* �жϵ�ǰ����==0? */
	Boolean equals2Zero() {
		// if (this.numerator == 0)
		// return true;
		// return false;
		return numerator == 0 ? true : false;
	}

	/*
	 * �Ƚ�this�ͷ���f�Ĵ�С
	 * 
	 * @return this>f:1 this<f:-1 else 0
	 */
	int compare(Fraction f) {
		int res = this.numerator * f.denominator - this.denominator
				* f.numerator;
		if (res > 0)
			return 1;
		else if (res < 0)
			return -1;
		else
			return 0;

	}

	/* ����this��f */
	void sub(Fraction f) {
		this.numerator = this.numerator * f.denominator - this.denominator
				* f.numerator;
		this.denominator = this.denominator * f.denominator;
	}
}
