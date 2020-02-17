package baek0217;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2178_¹Ì·ÎÅ½»ö {

	static int N, M;
	static int[][] map;
	static int[][] way;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		way = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(way[i], Integer.MAX_VALUE);
			char[] input = sc.next().toCharArray();
			for (int j = 0; j < input.length; j++) {
				map[i][j] = input[j] - '0';
				if(map[i][j] == 0) {
					way[i][j] = -1;
				}
			}
		}
		way[0][0] = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int count = way[p.y][p.x];
			for (int d = 0; d < 4; d++) {
				int ty = p.y + dy[d];
				int tx = p.x + dx[d];
				if(ty < N && tx < M && ty >= 0 && tx >= 0
						&& way[ty][tx] != -1) {
					if(way[ty][tx] > count + 1) {
						way[ty][tx] = count + 1;
						queue.add(new Point(ty, tx));
					}
				}
			}
		}
		
		System.out.println(way[N-1][M-1]);
		
	}
	
	public static class Point{
		int y;
		int x;
		Point(int y, int x){
			this.x = x;
			this.y = y;
		}
	}

}
