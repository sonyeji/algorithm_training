package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_7227_사랑의카운슬러 {
	static long min;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] x = new int[N];
			int[] y = new int[N];
			visit = new boolean[N];
			min = Long.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			combination(0, 0, x, y, 0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static void combination(int cnt, int target, int[] x, int[] y, long sx, long sy) {
		if (target == x.length) {
			if (cnt == x.length / 2) {
				long m = sx * sx + sy * sy;
				min = Math.min(min, m);
			}
			return;
		}
//		System.out.println(Arrays.toString(visit));
//		visit[target] = true;
//		System.out.println(cnt + ", " + (target + 1) + ", " + " '+' " + (sx + x[target]) + ", " + (sy + y[target]));
//		System.out.println(Arrays.toString(visit));
//		System.out.println();
		combination(cnt, target + 1, x, y, sx + x[target], sy + y[target]);
//		visit[target] = false;
		if (cnt < x.length / 2) {
//			System.out.println(Arrays.toString(visit));
//			visit[target] = false;
//			System.out.println(
//					(cnt + 1) + ", " + (target + 1) + ", " + " '-' " + (sx - x[target]) + ", " + (sy - y[target]));
//			System.out.println(Arrays.toString(visit));
//			System.out.println();
			combination(cnt + 1, target + 1, x, y, sx - x[target], sy - y[target]);
//			visit[target] = true;
		}
	}
}