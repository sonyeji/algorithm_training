package baek0221;

import java.util.Scanner;

public class Main_3109_»§Áý{

	static int R, C;
	static char[][] map;
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	static int count;
	static boolean isok;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		count = 0;
		isok = false;
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
			isok = false;
		}
		
		for (int i = 0; i < R; i++) {
			if(map[i][C-1] == 'O') {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int y, int x) {
		if(x == C-1) {
			isok = true;
			return;
		}
		for (int d = 0; d < 3; d++) {
			int ty = y + dy[d];
			int tx = x + dx[d];
			if(ty >= 0 && ty < R && tx < C
					&& map[ty][tx] == '.') {
				map[ty][tx] = 'O';
				dfs(ty, tx);
				if(isok)	return;
			}
		}
	}
}