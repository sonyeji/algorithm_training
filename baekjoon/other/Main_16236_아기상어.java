package baek0226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236_아기상어 {

	static int N;
	static int[][] map;
	static int[] dy = { -1, 0, 0, 1 };
	static int[] dx = { 0, -1, 1, 0 };
	static int baby = 2;
	static int eat = 0;
	static int sy = 0;
	static int sx = 0;
	static boolean isEat = false;
	static int time = 0;
	static int min = Integer.MAX_VALUE;
	static int ey = Integer.MAX_VALUE;
	static int ex = Integer.MAX_VALUE;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		sy = 0;
		sx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sy = i;
					sx = j;
					map[i][j] = 0;
				}
			}
		}

		while (true) {
			isEat = false;
			min = Integer.MAX_VALUE;
			bfs();
			if (min == Integer.MAX_VALUE) {
				System.out.println(time);
				return;
			} else {
				time += min;
				map[sy][sx] = 0;
				eat++;
				if (eat == baby) {
					baby++;
					eat = 0;
				}
			}
		}

	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(sy, sx));
		int count = 0;
		visit = new boolean[N][N];
		visit[sy][sx] = true;
		while (!queue.isEmpty()) {
			if(min != Integer.MAX_VALUE) return;
			int size = queue.size();
			count++;
			for (int s = 0; s < size; s++) {
				Point p = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ty = p.y + dy[d];
					int tx = p.x + dx[d];
					if (ty >= 0 && tx >= 0 && ty < N && tx < N && visit[ty][tx] == false && map[ty][tx] <= baby) {
						if (map[ty][tx] != 0 && map[ty][tx] < baby) {
							if (min > count) {
								sy = ty;
								sx = tx;
								min = count;
							}else if(min == count) {
								if(sy > ty) {
									sy = ty;
									sx = tx;									
								}else if(sy == ty) {
									if(sx > tx) {
										sy = ty;
										sx = tx;
									}else {
										continue;
									}
								}
							}
						}
						queue.add(new Point(ty, tx));
						visit[ty][tx] = true;
					}
				}
			}
		}
	}

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "y=" + y + ", x=" + x;
		}

	}

}
