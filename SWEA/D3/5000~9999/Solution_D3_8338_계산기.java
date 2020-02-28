package swea0228;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			int[] input = new int[num];
			for (int k = 0; k < num; k++) {
				input[k] = sc.nextInt();
			}
			int a = input[0];
			for (int k = 1; k < num; k++) {
				int sum = a + input[k];
				int mul = a * input[k];
				if (sum < mul)
					a = mul;
				else
					a = sum;
			}
			System.out.println("#" + test_case + " " + a);
		}
		sc.close();
	}
}