package com.learnwy.lesson;

import java.util.Scanner;

public class Demo01_1 {
	private static ContainsHX left = new ContainsHX("左岸");
	private static ContainsHX middle = new ContainsHX("船", 0, 0, 2);
	private static ContainsHX right = new ContainsHX("右岸", 3, 3);
	private static Scanner in = new Scanner(System.in);
	private static boolean isInit = false;
	private static int binalOfTotal = 1;

	public static void main(String[] args) {
		while (true) {
			Demo01_1.init();
			Demo01_1.gameStart();
			Demo01_1.isContinue();
		}
	}

	private static void isContinue() {
		System.out.println("是否继续(Y/Other):");
		if (!in.next().toUpperCase().equals("Y")) {
			System.exit(0);
		}
	}

	public static void gameStart() {
		R2B();
	}

	private static void R2B() {
		int num = right.getWild();
		int num2 = right.getPastor();
		int num3 = middle.getWild();
		int num4 = middle.getPastor();

		int temp = num2 - num;
		int size = middle.getMaxSize();
		int other = size % 2;
		int binal = size / 2;

		// 第一次到来
		if (num3 == 0 && num4 == 0) {
			if (num2 > num) {
				if (num >= binal) {
					middle.addWild(binal);
					middle.addPastor(binal + other);
					right.addWild(-binal);
					right.addPastor(-binal - other);
				} else if (num2 >= binal + other) {
					middle.addWild(num);
					middle.addPastor(binal + other);
					right.addWild(-num);
					right.addPastor(-binal - other);
				} else {
					middle.addPastor(num2);
					middle.addWild(num);
					right.addPastor(-num2);
					right.addWild(-num);
				}
			} else {
				if (num >= binal) {
					middle.addWild(binal);
					middle.addPastor(binal);
					right.addWild(-binal);
					right.addPastor(-binal);
				} else if (num2 >= binal + other) {
					middle.addWild(num);
					middle.addPastor(binal);
					right.addWild(-num);
					right.addPastor(-binal);
				} else {
					middle.addPastor(num2);
					middle.addWild(num);
					right.addPastor(-num2);
					right.addWild(-num);
				}
			}
		} else {
			// 其他次数
			right.addPastor(num4);
			right.addWild(num3);
			middle.addPastor(-num4);
			middle.addWild(-num3);
			num = right.getWild();
			num2 = right.getPastor();
			if (num2 > num) {
				if (num >= binal) {
					middle.addWild(binal);
					middle.addPastor(binal + other);
					right.addWild(-binal);
					right.addPastor(-binal - other);
				} else if (num2 >= binal + other) {
					middle.addWild(num);
					middle.addPastor(binal + other);
					right.addWild(-num);
					right.addPastor(-binal - other);
				} else {
					middle.addPastor(num2);
					middle.addWild(num);
					right.addPastor(-num2);
					right.addWild(-num);
				}
			} else if (num2 == num) {
				if (num2 >= binal) {
					middle.addPastor(binal);
					middle.addWild(binal);
					right.addPastor(-binal);
					right.addWild(-binal);
				} else {
					middle.addPastor(num);
					middle.addWild(num);
					right.addPastor(-num);
					right.addWild(-num);
				}
			} else {
				if (num - num2 > 1) {
					if (num - num2 > binal) {
						if (num > middle.getMaxSize()) {
							middle.addWild(middle.getMaxSize());
							right.addWild(-middle.getMaxSize());
						} else {
							middle.addWild(num);
							right.addWild(-num);
						}
					} else {
						middle.addWild(num - num2);
						right.addWild(num2 - num);
					}
				} else {
					if (num2 <= middle.getMaxSize()) {
						middle.addPastor(num2);
						right.addPastor(-num2);
					} else {
						middle.addWild(binal + 1);
						right.addWild(-binal - 1);
					}
				}
			}

		}

		printPerson("<-");
		if (checkGameOver()) {
			System.out.print("程序完成");
			return;
		}
		L2B();
	}

	private static void L2B() {
		int num = middle.getWild();
		int num2 = middle.getPastor();
		int binal = middle.getMaxSize() / 2;
		left.addPastor(num2);
		left.addWild(num);
		middle.addPastor(-num2);
		middle.addWild(-num);
		num = left.getWild();
		num2 = left.getPastor();
		if (num2 - num > 0) {
			if (right.getPastor() == 0) {
				middle.addWild(1);
				left.addWild(-1);
			} else {
				middle.addPastor(1);
				left.addPastor(-1);
			}
		} else if (num2 == num) {
			if (num2 <= binal) {
				middle.addPastor(num2);
				left.addPastor(-num2);
			} else {
				middle.addWild(1);
				left.addWild(-1);
			}
		} else {
			middle.addWild(num - num2);
			left.addWild(num2 - num);
		}
		printPerson("->");
		R2B();
	}

	private static boolean checkGameOver() {
		return right.getWild() <= 0 && right.getPastor() <= 0;
	}

	private static void checkInit() {
		if ((right.getWild() - right.getPastor()) > 0) {
			System.out.println("野人不能超过传教士");
			Demo01.init();
		}
		isInit = true;
	}

	public static void init() {
		if (ifChoice()) {
			System.out.print("请输入野人数:");
			right.setWild(in.nextInt());
			System.out.println();
			System.out.print("请输入传教士数:");
			right.setPastor(in.nextInt());
			System.out.println("请输入船载最大人数:");
			middle.setMaxSize(in.nextInt());
			binalOfTotal = middle.getMaxSize() / 2;
			left.setAll(0, 0);
			middle.setAll(0, 0);
		} else {
			left.setAll(0, 0);
			middle.setAll(0, 0, 2);
			right.setAll(3, 3);
			isInit = true;
			binalOfTotal = 1;
		}
		checkInit();
	}

	private static boolean ifChoice() {
		System.out.println("是否重新设置右岸人数(Y/Other)(默认均为3):");
		return in.next().toUpperCase().equals("Y");
	}

	private static void printPerson(String direction) {
		System.out.println("\t左岸人数\t船上人数\t右岸人数");
		System.out.println("传教士:\t" + left.getPastor() + direction + "\t" + middle.getPastor() + direction + "\t"
				+ right.getPastor());
		System.out.println(
				"野人:\t" + left.getWild() + direction + "\t" + middle.getWild() + direction + "\t" + right.getWild());
		System.out.println("################################");
	}
}

class ContainsHX {
	private int maxSize = 9999;
	private int wild = 0;
	private int pastor = 0;
	private String Name = "默认";
	private int total = 0;

	public int getTotal() {
		return total;
	}

	public ContainsHX() {
	}

	public void setAll(int wild, int pastor) {
		this.wild = wild;
		this.pastor = pastor;
		getT();
	}

	public void setAll(int wild, int pastor, int maxSize) {
		this.wild = wild;
		this.pastor = pastor;
		this.maxSize = maxSize;
		getT();
	}

	public ContainsHX(String Name) {
		this.Name = Name;
	}

	public ContainsHX(String Name, int maxSize) {
		this(Name);
		this.maxSize = maxSize;
	}

	public ContainsHX(String Name, int wild, int pastor) {
		this(Name);
		this.wild = wild;
		this.pastor = pastor;
		getT();
	}

	public ContainsHX(String Name, int wild, int pastor, int maxSize) {
		this(Name);
		this.wild = wild;
		this.pastor = pastor;
		this.maxSize = maxSize;
		getT();
	}

	public ContainsHX(int maxSize) {
		this.maxSize = maxSize;
	}

	public ContainsHX(int wild, int pastor) {
		this.wild = wild;
		this.pastor = pastor;
		getT();
	}

	public ContainsHX(int wild, int pastor, int maxSize) {
		this.wild = wild;
		this.pastor = pastor;
		this.maxSize = maxSize;
		getT();
	}

	private void getT() {
		this.total = this.wild + this.pastor;
	}

	public int getMaxSize() {
		return this.maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public void addWild(int num) {
		checkAdd(num);
		this.wild += num;
		getT();
	}

	public void addPastor(int num) {
		checkAdd(num);
		this.pastor += num;
		getT();
	}

	public int getWild() {
		return wild;
	}

	public void setWild(int wild) {
		this.wild = wild;
		getT();
	}

	public int getPastor() {
		return pastor;
	}

	public void setPastor(int pastor) {
		this.pastor = pastor;
		getT();
	}

	public void checkAdd(int addNum) {
		if (this.total + addNum > this.maxSize || this.total + addNum < 0) {
			throw new IllegalArgumentException("参数对于" + this.Name + "非法");
		}
	}
}
