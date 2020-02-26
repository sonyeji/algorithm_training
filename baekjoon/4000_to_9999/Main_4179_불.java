package baek0226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4179_บา {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int R, C;
	static char[][] map;
	static boolean isExit = false;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		int sy = 0;
		int sx = 0;

		Queue<Point> Fqueue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'J') {
					sy = i;
					sx = j;
				}
				if (map[i][j] == 'F') {
					Fqueue.add(new Point(i, j));
				}
			}
		}
		
		bfs(sy, sx, Fqueue);

		if(isExit) {
			System.out.println(min);
		}else {
			System.out.println("IMPOSSIBLE");
		}
	}

	static void bfs(int sy, int sx, Queue<Point> Fqueue) {
		Queue<Point> Jqueue = new LinkedList<Point>();
		Jqueue.add(new Point(sy, sx));
		int count = 0;
		map[sy][sx] = '2';
		count++;
		while (true) {
			if (Jqueue.isEmpty())
				break;
			int jsize = Jqueue.size();
			for (int s = 0; s < jsize; s++) {
				Point jp = Jqueue.poll();
				if(map[jp.y][jp.x] != '2')	continue;
				for (int d = 0; d < 4; d++) {
					int ty = jp.y + dy[d];
					int tx = jp.x + dx[d];
					if (ty < 0 || tx < 0 || ty >= R || tx >= C) {
						isExit = true;
						min = count;
						break;
					}
					if (map[ty][tx] == '.') {
						Jqueue.add(new Point(ty, tx));
						map[ty][tx] = '2';
					}
				}
				if (isExit)
					break;
			}
			if (isExit)
				break;
			count++;
			if (Fqueue.isEmpty())
				continue;
			int fsize = Fqueue.size();
			for (int s = 0; s < fsize; s++) {
				Point fp = Fqueue.poll();
				for (int d = 0; d < 4; d++) {
					int ty = fp.y + dy[d];
					int tx = fp.x + dx[d];
					if (ty >= 0 && tx >= 0 && ty < R && tx < C
							&& map[ty][tx] != '#' && map[ty][tx] != 'F') {
						Fqueue.add(new Point(ty, tx));
						map[ty][tx] = 'F';
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
