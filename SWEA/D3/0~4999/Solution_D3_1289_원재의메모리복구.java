package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구 {

	static int T;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			String s = sc.next();
			int start = s.indexOf('1');
			if (start == -1) {
				System.out.println("#" + test_case + " " + 0);
				continue;
			}

			int count = 1;
			for (int i = start; i < s.length() - 1; i++) {
				if (s.charAt(i) != s.charAt(i + 1)) {
					count++;
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
	}

}
