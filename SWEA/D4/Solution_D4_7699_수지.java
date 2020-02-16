package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D4_7699_수지 {

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int d;
	static boolean[][] visit;
	static char[][] map;
	static int R;
	static int C;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];
			visit = new boolean[R][C];
			int max = 0;
			
			for (int i = 0; i < R; i++) {
				map[i] = sc.next().toCharArray();
			}
			
			dfs(0, 0);
			
			System.out.println("#" + test_case + " " + max);
		}
		
		sc.close();
	}
	
	public static void dfs(int y, int x) {
		visit[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ty = y + dy[d];
			int tx = x + dx[d];
			if(ty >= 0 && tx >= 0 && tx < C && ty < R
					&& map[ty][tx] == 1 && visit[ty][tx] == false) {
				dfs(ty, tx);
			}
		}
	}

}
