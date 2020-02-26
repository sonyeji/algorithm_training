package baek0226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2206_벽부수고이동 {

	static int N, M;
	static int[][][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < tmp.length; j++) {
				map[i][j][0] = (tmp[j] - '0') * -1;
				map[i][j][1] = (tmp[j] - '0') * -1;
			}
		}
		
		if(N == 1 && M == 1) {
			System.out.println(1);
			return;
		}
		
		map[0][0][0] = 2;
		map[0][0][0] = 2;
		bfs(0, 0);

		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(y, x, 0));
		int count = 2;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point p = queue.poll();
				if(p.y == N-1 && p.x == M-1) {
					min = count-1;
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ty = p.y + dy[d];
					int tx = p.x + dx[d];
					
					if(!(ty >= 0 && tx >= 0 && ty < N && tx < M))
						continue;
					if(p.broken == 0) {
						if(map[ty][tx][0] == 0) {
							map[ty][tx][0] = count;
							queue.add(new Point(ty, tx, p.broken));							
						}else if(map[ty][tx][0] == -1){
							map[ty][tx][1] = count;
							queue.add(new Point(ty, tx, 1));
						}
					}else {
						if(map[ty][tx][1] == 0) {
							map[ty][tx][1] = count;
							queue.add(new Point(ty, tx, p.broken));							
						}
					}
					
				}
			}
			count++;
		}
	}
	
	
//	static void print() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	
	static class Point {
		int y;
		int x;
		int broken;

		Point(int y, int x, int broken) {
			this.y = y;
			this.x = x;
			this.broken = broken;
		}

		@Override
		public String toString() {
			return "y=" + y + ", x=" + x;
		}

	}

}
