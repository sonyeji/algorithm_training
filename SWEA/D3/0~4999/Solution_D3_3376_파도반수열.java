package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_3376_파도반수열 {

	static long[] list = new long[1000];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			System.out.println("#" + test_case +" " + padoban(N));
		}
	}
	
	public static long padoban(int N) {
		if(N == 1 || N == 2 || N == 3) {
			return 1;
		}
		if(list[N] != 0)	return list[N];
		else {
			long result = padoban(N-2) + padoban(N-3);
			list[N] = result;
			return result;
		}
		
		
	}

}
