package swea0217;


import java.util.Scanner;

public class Solution_D4_8659_GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			long b = 2L;
			long a = 1L;
			long c = 0L;
			int count = 1;
			while(count != k) {
				c = a+b;
				a = b;
				b = c;
				count++;
			}
			System.out.println("#" + tc + " " + b + " " + a);
		}
	}

}
