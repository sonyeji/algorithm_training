package baek0221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4963_¼¶ÀÇ°³¼ö {
	static int w, h;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (w == 0 && h == 0)
				return;
			map = new int[h][w];
			visit = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void bfs(int y, int x) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(y, x));
		visit[y][x] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 8; d++) {
				int ty = p.y + dy[d];
				int tx = p.x + dx[d];

				if (ty >= 0 && tx >= 0 && ty < h && tx < w && map[ty][tx] != 0 && !visit[ty][tx]) {
					visit[ty][tx] = true;
					queue.offer(new Point(ty, tx));
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