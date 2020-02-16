package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5356_세로로말해요 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = 15;
			int K = 5;
			
			char[][] data = new char[K][N];
			
			for (int i = 0; i < K; i++) {
				Arrays.fill(data[i], ' ');
			}
			for (int i = 0; i < K; i++) {
				String ns = sc.next();
				System.arraycopy(ns.toCharArray(), 0, data[i], 0, ns.length());
			}
			
			System.out.print("#" + test_case + " ");
			
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < data.length; i++) {
					if(data[i][j] != ' ')
						System.out.print(data[i][j]);
				}
			}
			System.out.println();
		}
	}

}
