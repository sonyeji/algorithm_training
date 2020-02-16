package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			int[] items = new int[N];
			
			for (int i = 0; i < N; i++) {
				items[i] = sc.nextInt();
			}
			
			int max = -1;
			int[][] sum = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					sum[i][j] = items[i] + items[j];
					if(max < sum[i][j] && sum[i][j] <= M) {
						max = sum[i][j];
					}
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}

}
