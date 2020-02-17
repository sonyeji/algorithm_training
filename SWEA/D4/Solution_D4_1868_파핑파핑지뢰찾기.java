package swea0217;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1868_파핑파핑지뢰찾기 {
	static int N;
	static char[][] map;
	static int[][] map2;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int count;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new char[N][N];
			map2 = new int[N][N];
			count = 0;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '*') {
						map2[i][j] = -1;
					}
					if (map[i][j] == '.' && nearboom(i, j)) {
						map2[i][j] = 1;
						count++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map2[i][j] == 1 && nearzero(i, j)) {
						count--;
					}
					
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map2[i][j] == 0 && !visit[i][j]) {
						count++;
						visit[i][j] = true;
						pop(i, j);
					}
				}
			}

			System.out.println("#" + test_case + " " + count);

		}
	}
	
	public static boolean nearboom(int y, int x) {
		for (int d = 0; d < 8; d++) {
			int ty = y + dy[d];
			int tx = x + dx[d];
			if (ty >= 0 && tx >= 0 && ty < N && tx < N && map[ty][tx] == '*') {
				return true;
			}
		}
		return false;
	}

	public static boolean nearzero(int y, int x) {
		for (int d = 0; d < 8; d++) {
			int ty = y + dy[d];
			int tx = x + dx[d];
			if (ty >= 0 && tx >= 0 && ty < N && tx < N && map2[ty][tx] == 0) {
				return true;
			}
		}
		return false;
	}

	public static void pop(int y, int x) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(y, x));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 8; d++) {
				int ty = p.y + dy[d];
				int tx = p.x + dx[d];
				if (ty >= 0 && tx >= 0 && ty < N && tx < N && map2[ty][tx] == 0) {
					if(visit[ty][tx])	continue;
					visit[ty][tx] = true;
					queue.add(new Point(ty, tx));
				}
			}
		}

	}


	public static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
