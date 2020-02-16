package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_3307_최장증가부분수열 {

	static int T;
	static int N;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			int[] num = new int[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			
			int[] count = new int[N];
			Arrays.fill(count, 1);
			
			int max = 0;
			
			for (int i = N-1; i >= 0; i--) {
				int base = count[i];
				for (int j = i+1; j < N; j++) {
					if(num[i] < num[j]) {
						count[i] = count[i] > base+count[j] ? count[i]:count[j]+base;
						max = max>count[i]?max:count[i];
					}
				}
			}
			
			System.out.println("#"+test_case + " " + max);
		}
	}

}
