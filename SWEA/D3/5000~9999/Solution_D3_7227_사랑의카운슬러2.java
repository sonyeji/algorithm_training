package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_7227_사랑의카운슬러2 {
	static long min;
	static boolean[] visit;
	static int[] x;
	static int[] y;
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			R = N/2;
			x = new int[N];
			y = new int[N];
			visit = new boolean[N];
			min = Long.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			nCr(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void nCr(int start, int count) {
		if(count == R) {
			int sx = 0;
			int sy = 0;
			for (int i = 0; i < visit.length; i++) {
				if(visit[i]) {
					sx += x[i];
					sy += y[i];
				}else {
					sx -= x[i];
					sy -= y[i];
				}
			}
			long m = (0L+sx) * sx + (0L+sy) * sy;
			min = Math.min(min, m);
			return ;
		}
		
		for (int i = start; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				nCr(i+1, count+1);
				visit[i] = false;
			}
		}
	}
}