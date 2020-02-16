package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1859_백만장자 {

	static int T;
	static int N;
	static int[] values;
	static long sum;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			values = new int[N];
			sum = 0L;
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				values[i] = Integer.parseInt(st.nextToken().trim());
			}
			int now;
			int max = values[N-1];
			for (int i = N-2; i >= 0; i--) {
				now = values[i];
				if (max >= now) {
					sum -= now;
					sum += max;
				} else {
					max = now;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}

	public static void print(int[] values) {
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
}
