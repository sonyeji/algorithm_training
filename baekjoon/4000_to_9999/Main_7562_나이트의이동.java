package baek0226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562_나이트의이동 {
	static int N;
	static int[][] map;
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			int sy = sc.nextInt();
			int sx = sc.nextInt();
			map[sy][sx] = 2;
			int ey = sc.nextInt();
			int ex = sc.nextInt();
			
			if(sy == ey && sx == ex) {
				System.out.println(0);
				continue;
			}
			
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(sy, sx));
			int count = 1;
			boolean isEnd = false;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for (int s = 0; s < size; s++) {
					Point p = queue.poll();
					for (int d = 0; d < 8; d++) {
						int ty = p.y + dy[d];
						int tx = p.x + dx[d];
						if(ty == ey && tx == ex) {
							isEnd = true;
						}
						if(ty >= 0 && tx >= 0 && ty < N && tx < N
								&& map[ty][tx] == 0) {
							map[ty][tx] = 2;
							queue.add(new Point(ty, tx));
						}
					}
					if(isEnd)	break;
				}
				if(isEnd)	break;
				count++;
			}
			System.out.println(count);
			
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
