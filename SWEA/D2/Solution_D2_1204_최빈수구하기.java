package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] grade = new int[101];
			
			for (int i = 0; i < 1000; i++) {
				int g = sc.nextInt();
				grade[g]++;
			}
			
			int max = 0;
			int max_grade = 0;
			for (int i = 0; i < grade.length; i++) {
				if(max <= grade[i]) {
					max = grade[i];
					max_grade = i;
				}
			}
			
			System.out.println("#" + test_case + " " + max_grade);
		}
		sc.close();
	}
}
