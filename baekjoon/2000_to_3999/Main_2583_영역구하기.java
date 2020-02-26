package baek0226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2583_영역구하기 {
	static int M, N, K;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[M][N];
		
		for (int i = 0; i < K; i++) {
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();
			
			for (int j = sy; j < ey; j++) {
				for (int j2 = sx; j2 < ex; j2++) {
					map[j][j2] = 1;
				}
			}
		}
		int count = 0;
		ArrayList<Integer> list =new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					count++;
					list.add(bfs(i, j));
				}
			}
		}
		int[] sort = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			sort[i] = list.get(i);
		}
		
		Arrays.sort(sort);
		System.out.println(count);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(sort[i] + " ");
		}
	}
	
	static int bfs(int y, int x)
	{
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(y, x));
		map[y][x] = 2;
		int count = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			count++;
			for (int d = 0; d < 4; d++) {
				int ty = p.y + dy[d];
				int tx = p.x + dx[d];
				
				if(ty >= 0 && tx >= 0 && ty < M && tx < N
						&& map[ty][tx] == 0) {
					queue.add(new Point(ty, tx));
					map[ty][tx] = 2;
				}
			}
		}
		return count;
	}
	
	static class Point{
		int y;
		int x;
		Point(int y, int x){
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "y=" + y + ", x=" + x;
		}
		
	}
	
//	static void print() {
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
