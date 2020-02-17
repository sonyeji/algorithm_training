package swea0217;


import java.util.Scanner;

public class Solution_D4_1219_±Ê√£±‚ {

	static int A = 0;
	static int B = 99;
	static int[][] list;
	static int ok = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int L = sc.nextInt();
			ok = 0;
			list = new int[2][100];
			for (int i = 0; i < L; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				if (list[0][s] == 0)
					list[0][s] = e;
				else
					list[1][s] = e;
			}
			go(0);
			System.out.println("#" + T + " " + ok);
		}
	}

	public static void go(int s) {
		if (s == 99) {
			ok = 1;
			return;
		}
		int next1 = list[0][s];
		int next2 = list[1][s];
		if (next1 != 0) {
			go(next1);
		}
		if (next2 != 0) {
			go(next2);
		}
	}

}
