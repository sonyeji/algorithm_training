package swea0217;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1249_º¸±Þ·Î {

	static int N;
	static int[][] map;
	static int[] dy = {-1,0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int min = Integer.MAX_VALUE;
	static boolean[][] visit;
	static int[][] cost;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			cost = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE);
				char[] input = sc.next().toCharArray();
				for (int j = 0; j < input.length; j++) {
					map[i][j] = input[j] - '0';
				}
			}
			bfs(0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void bfs(int y, int x) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(y, x, 0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; d++) {
				int ty = p.y + dy[d];
				int tx = p.x + dx[d];
				if(ty >= 0 && tx >= 0 && ty < N && tx < N) {
					if(cost[ty][tx] > map[ty][tx] + p.cost) {
						cost[ty][tx] = map[ty][tx] + p.cost;
						if(ty == N-1 && tx == N-1 && min > cost[ty][tx])
							min = cost[ty][tx];
						else queue.add(new Point(ty, tx, cost[ty][tx]));
							
					}
				}
			}
		}
	}
	
	public static class Point{
		int x;
		int y;
		int cost;
		Point(int y, int x, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

}
