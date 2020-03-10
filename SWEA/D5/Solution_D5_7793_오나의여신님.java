package swea0309;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D5_7793_오나의여신님 {

	static char[][] map;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;
	static Queue<Point> devil, player;
	static boolean isover;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];

			devil = new LinkedList<>();
			player = new LinkedList<>();
			isover = false;
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
				for (int j = 0; j < M; j++) {
					if(map[i][j] == '*') {
						devil.offer(new Point(i, j, 0));
					}else if(map[i][j] == 'S') {
						player.offer(new Point(i, j, 0));
					}
				}
			}

//			for (char[] row: map) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println(devil);
//			System.out.println(player);
			
			while(true) {
				if(player.size() == 0) {
					System.out.println("#" + tc + " GAME OVER");
					break;
				}
				bfsdevil();
				int result = bfsPlayer();
				if(result != -1) {
					System.out.println("#" + tc + " " + result);
					break;
				}
			}
		}
		sc.close();
	}
	
	private static int bfsPlayer() {
		int size = player.size();
		while (size-- > 0) {
			Point front = player.poll();

			for (int d = 0; d < 4; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];

				if (isIn(nr, nc)) {
					if (map[nr][nc]=='D') {
						return front.depth+1;
					}
					else if(map[nr][nc] == '.') {
						map[nr][nc] = 'S';
						player.offer(new Point(nr, nc, front.depth+1));
					}
				}
			}
		}
		
		return -1;
	}

	static void bfsdevil() {
		int size = devil.size();
		while (size-- > 0) {
			Point front = devil.poll();

			for (int d = 0; d < 4; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];

				if (isIn(nr, nc)) {
					if (map[nr][nc]=='.' || map[nr][nc] == 'S') {
						map[nr][nc] = '*';
						devil.offer(new Point(nr, nc, front.depth + 1));
					}
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < N && c < M;
	}

	static class Point {
		int row;
		int col;
		int depth;

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}
	}

}
