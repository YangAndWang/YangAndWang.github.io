package com.learnwy.lesson;

import java.util.Scanner;

/**
 * 题目：设有3个传教士和3个野人来到河边， 打算乘一只船从右岸到左岸去。 该船的负载能力为两人。 在任何时候，如果野人人数超过传教士人数，野人
 * 就会把传教士吃掉。 他们怎样才能用这条船安全的把所有人都渡过河去?
 * 
 * @author wangyang
 *
 */

// R.2 - R.1 = 2 R.2 -2
// R.2 -R.1 = 1
//
//
public class Demo01 {
	static ContainsH left = new ContainsH();
	static ContainsH middle = new ContainsH();
	static ContainsH right = new ContainsH(3, 3);
	static Scanner in = new Scanner(System.in);

	// static boolean isChoice = false;

	public static void main(String[] args) {
		while (true) {
			Demo01.init();
			Demo01.gameStart();
			Demo01.isContinue();
		}
	}

	/**
	 * 开始游戏,从右岸开始往左岸走
	 */
	public static void gameStart() {
		R2B();
	}

	/**
	 * 从右岸到船上
	 */
	private static void R2B() {
		int num = right.getPerson1();
		int num2 = right.getPerson2();
		switch (middle.getPersons()) {
		/* 游戏开始 */
		case "00":
			switch (num2) {
			case 0:
				if (num <= 2) {
					middle.addP1(num);
					right.deP1(num);
				} else {
					middle.addP1(2);
					right.deP1(2);
				}
				break;
			case 1:
				if (num <= 0) {
					middle.addP2(1);
					right.deP2(1);
				} else {
					middle.addP1(1);
					middle.addP2(1);
					right.deP1(1);
					right.deP2(1);
				}
				break;
			case 2:
				middle.addP2(2);
				right.deP2(2);
				break;
			default:
				if (num == 0 || num2 - num >= 2) {
					middle.addP2(2);
					right.deP2(2);
				} else {
					middle.addP1(1);
					middle.addP2(1);
					right.deP1(1);
					right.deP2(1);
				}
				break;
			}
			break;
		// 船上必定有一人从左岸将船开过来 有且只能有一人
		case "01":
			right.addP2(1);
			middle.deP2(1);
			switch (num2 = num2 + 1) {
			case 0:
				if (num <= 2) {
					middle.addP1(num);
					right.deP1(num);
				} else {
					middle.addP1(2);
					right.deP1(2);
				}
				break;
			case 1:
				if (num <= 0) {
					middle.addP2(1);
					right.deP2(1);
				} else {
					middle.addP1(1);
					middle.addP2(1);
					right.deP1(1);
					right.deP2(1);
				}
				break;
			case 2:
				middle.addP2(2);
				right.deP2(2);
				break;
			default:
				if (num == 0 || num2 - num >= 2) {
					middle.addP2(2);
					right.deP2(2);
				} else {
					middle.addP1(1);
					middle.addP2(1);
					right.deP1(1);
					right.deP2(1);
				}
				break;
			}
			break;
		case "10":
			right.addP1(1);
			middle.deP1(1);
			num += 1;
			switch (num2) {
			case 0:
				if (num <= 2) {
					middle.addP1(num);
					right.deP1(num);
				} else {
					middle.addP1(2);
					right.deP1(2);
				}
				break;
			case 1:
				if (num <= 0) {
					middle.addP2(1);
					right.deP2(1);
				} else {
					middle.addP1(1);
					middle.addP2(1);
					right.deP1(1);
					right.deP2(1);
				}
				break;
			case 2:
				middle.addP2(2);
				right.deP2(2);
				break;
			default:
				if (num == 0 || num2 - num >= 2) {
					middle.addP2(2);
					right.deP2(2);
				} else {
					middle.addP1(1);
					middle.addP2(1);
					right.deP1(1);
					right.deP2(1);
				}
				break;
			}
			break;
		default:
			System.out.println("程序出错,请联系管理员");
			System.exit(0);
			break;
		}
		System.out.println("\t\t船<-右");
		printPerson("<-");
		if (checkGameOver()) {
			System.out.print("程序完成");
			return;
		}
		L2B();
	}

	private static void L2B() {
		int num = left.getPerson1();
		int num2 = left.getPerson2();
		switch (middle.getPersons()) {
		case "11":
			left.addP1(1);
			left.addP2(1);
			middle.deP1(1);
			middle.deP2(1);
			num += 1;
			num2 += 1;
			if (num2 == 1) {
				middle.addP2(1);
				left.deP2(1);
			} else if (num2 > num) {
				middle.addP2(1);
				left.deP2(1);
			} else {
				middle.addP1(1);
				left.deP1(1);
			}
			break;
		case "20":
			left.addP1(2);
			num += 2;
			middle.deP1(2);
			if (num2 == 1) {
				middle.addP2(1);
				left.deP2(1);
			} else if (num2 > num) {
				middle.addP2(1);
				left.deP2(1);
			} else {
				middle.addP1(1);
				left.deP1(1);
			}
			break;
		case "02":
			left.addP2(2);
			num2 += 2;
			middle.deP2(2);
			if (num2 == 1) {
				middle.addP2(1);
				left.deP2(1);
			} else if (num2 > num) {
				middle.addP2(1);
				left.deP2(1);
			} else {
				middle.addP1(1);
				left.deP1(1);
			}
			break;
		default:
			System.out.println("程序出错,请联系管理员");
			System.exit(0);
			break;
		}
		System.out.println("\t\t左->船");
		printPerson("->");
		R2B();
	}

	private static boolean checkGameOver() {
		return right.getPerson1() <= 0 && right.getPerson2() <= 0;
	}

	private static void printPerson(String direction) {
		System.out.println("\t左岸人数\t船上人数\t右岸人数");
		System.out.println("传教士:\t" + left.getPerson2() + direction + "\t" + middle.getPerson2() + direction + "\t"
				+ right.getPerson2());
		System.out.println("野人:\t" + left.getPerson1() + direction + "\t" + middle.getPerson1() + direction + "\t"
				+ right.getPerson1());
		System.out.println("################################");
	}

	public static void checkInit() {
		if ((right.getPerson1() - right.getPerson2()) > 0) {
			System.out.println("野人不能超过传教士");
			Demo01.init();
		}
	}

	private static void isContinue() {
		System.out.println("是否继续(Y/Other):");
		if (!in.next().toUpperCase().equals("Y")) {
			System.exit(0);
		}
	}

	private static boolean ifChoice() {
		System.out.println("是否重新设置右岸人数(Y/Other)(默认均为3):");
		return in.next().toUpperCase().equals("Y");
	}

	public static void init() {
		if (ifChoice()) {
			System.out.print("请输入野人数:");
			right.setPerson1(in.nextInt());
			System.out.println();
			System.out.print("请输入传教士数:");
			right.setPerson2(in.nextInt());
			left.setAll(0, 0);
			middle.setAll(0, 0);
		} else {
			left.setAll(0, 0);
			middle.setAll(0, 0);
			right.setAll(3, 3);
		}
		Demo01.checkInit();
	}

	@SuppressWarnings("unused")
	private static class ContainsH {
		// 野人
		private int person1 = 0;
		// 传教士
		private int person2 = 0;

		public ContainsH() {
		}

		public String getPersons() {
			return person1 + "" + person2;
		}

		public boolean isNoPerson() {
			return person2 == 0 && person1 == 0;
		}

		public int equals() {
			return this.person1 - this.person2;
		}

		public void setAll(int p1, int p2) {
			this.person1 = p1;
			this.person2 = p2;
		}

		ContainsH(int p1, int p2) {
			this.person1 = p1;
			this.person2 = p2;
		}

		public int deP1(int num) {
			return person1 = person1 - num;
		}

		public int deP2(int num) {
			return person2 = person2 - num;
		}

		public int addP1(int num) {
			return person1 = person1 + num;
		}

		public int addP2(int num) {
			return person2 = person2 + num;
		}

		public int getPerson1() {
			return person1;
		}

		public void setPerson1(int person1) {
			this.person1 = person1;
		}

		public int getPerson2() {
			return person2;
		}

		public void setPerson2(int person2) {
			this.person2 = person2;
		}
	}
}
