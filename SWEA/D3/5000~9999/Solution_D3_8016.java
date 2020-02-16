package ssafy0211;

import java.util.Scanner;

public class Solution_D3_8016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			long n = sc.nextInt();
			long count = 1L;
			long s;
			long e;
			s = 2 * ((n-1) * (n-1) +1) - 1;
			e = 2 * (n * n) - 1;
			
			System.out.println("#" + test_case + " " + s + " " + e);
		}
	}

}
