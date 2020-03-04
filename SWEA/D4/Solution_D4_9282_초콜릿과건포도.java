package swea0303;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_9282_초콜릿과건포도 {

	static int[][] map;
	static int n, m;
	static int result;
	static int[][][][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][m];
			memo = new int[n+1][m+1][n+1][m+1];
			for (int[][][] d1 : memo) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			result = dfs(0, 0, n, m);

			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}

	static int dfs(int y, int x, int h, int w) {
		if (w == 1 && h == 1) {
			return 0;
		}
		if(memo[y][x][h][w] != Integer.MAX_VALUE) {
			return memo[y][x][h][w];
		}

		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}

		for (int i = 1; i < h; i++) {
			if(memo[y][x][i][w] == Integer.MAX_VALUE)
				memo[y][x][i][w] = dfs(y, x, i, w);
			if(memo[y+i][x][h-i][w] == Integer.MAX_VALUE)
				memo[y+i][x][h-i][w] = dfs(y + i, x, h - i, w);
			memo[y][x][h][w] = Math.min(memo[y][x][h][w], sum + memo[y][x][i][w] + memo[y+i][x][h-i][w]);
		}

		for (int j = 1; j < w; j++) {
			if(memo[y][x][h][j] == Integer.MAX_VALUE)
				memo[y][x][h][j] = dfs(y, x, h, j);
			if(memo[y][x+j][h][w-j] == Integer.MAX_VALUE)
				memo[y][x+j][h][w-j] = dfs(y, x + j, h, w - j);
			memo[y][x][h][w] = Math.min(memo[y][x][h][w], sum + memo[y][x][h][j] + memo[y][x+j][h][w-j]);
		}
		
		return memo[y][x][h][w];
	}

}
