package baek0217;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_7576_≈‰∏∂≈‰1 {

	static int M, N;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		Queue<Point> queue = new LinkedList<>();
		int zero = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					queue.add(new Point(i, j, 0));
					visit[i][j] = true;
				}
				if(map[i][j] == 0)
					zero++;
			}
		}
		if(zero == 0) {
			System.out.println("0");
			return;
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ty = p.y + dy[d];
				int tx = p.x + dx[d];
				if(ty >= 0 && tx >= 0 && ty < N && tx < M && map[ty][tx] != -1) {
					int day = p.day+1;
					if(map[ty][tx] != 0) {
						if(day < map[ty][tx]) {
							map[ty][tx] = Math.min(day, map[ty][tx]);
							queue.add(new Point(ty, tx, p.day + 1));
						}else {
							continue;
						}
					}
					else {
						map[ty][tx] = day;
						queue.add(new Point(ty, tx, p.day + 1));						
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					max = -1;
					break;
				}
				max = Math.max(max, map[i][j]);
			}
			if(max == -1) {
				break;
			}
		}
		System.out.println(max);
		
	}

	public static class Point{
		int y;
		int x;
		int day;
		Point(int y, int x, int day){
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}