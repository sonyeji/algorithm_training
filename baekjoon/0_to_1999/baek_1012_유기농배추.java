package baek0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1012_유기농배추{

	static int M, N;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int d;
	static int[][] map;
	static int[][] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 0; test_case < T; test_case++) {
			M = sc.nextInt(); // 가로
			N = sc.nextInt(); // 세로
			int K = sc.nextInt(); // 배추 개수
			map = new int[N][M];
			visit = new int[N][M];
			int count = 0;
			
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				map[y][x] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1 && visit[i][j] == 0) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		sc.close();
	}

	public static void bfs(int y, int x) {
		visit[y][x] = 1;
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(y, x));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ty = p.y + dy[i];
				int tx = p.x + dx[i];
				
				if(tx >= 0 && tx < M && ty >= 0 && ty < N
						&& map[ty][tx] == 1 && visit[ty][tx] == 0) {
					visit[ty][tx] = 1;
					queue.add(new Point(ty, tx));
				}
			}
		}
	}
	
	public static class Point{
		int x;
		int y;
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}