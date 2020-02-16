package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D4_7699_수지2 {

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static char[][] map;
	static boolean[] alphabet;
	static int ans;
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
			alphabet = new boolean[26];
			
			for (int i = 0; i < R; i++) {
				map[i] = sc.next().toCharArray();
			}
			ans = 0;
			alphabet[map[0][0] - 'A'] = true;
			dfs(0, 0, 1);
			
			System.out.println("#" + test_case + " " + ans);
		}
		
		sc.close();
	}
	
	public static void dfs(int y, int x, int cnt) {
		if(ans < cnt) {
			ans = cnt;
		}
		if(cnt == 26)	return;
		
		alphabet[map[y][x] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int ty = y + dy[d];
			int tx = x + dx[d];
			if(ty >= 0 && tx >= 0 && tx < C && ty < R
					&& alphabet[map[ty][tx] - 'A'] == false) {
				dfs(ty, tx, cnt+1);
			}
		}
		
		alphabet[map[y][x] - 'A'] = false;
	}

}
