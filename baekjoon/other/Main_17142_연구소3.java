package baek0221;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17142_¿¬±¸¼Ò3 {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] vmap;
	static boolean isAll;
	static LinkedList<Point> virus;
	static int n;
	static int[] list;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		vmap = new int[N][N];
		isAll = false;
		virus = new LinkedList<>();
		list = new int[M];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}
		int zero = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0)
					zero++;
			}
		}
		if(zero == 0) {
			System.out.println(0);
			return;
		}
		
		n = virus.size();
		
		combi(0, 0);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	public static void combi(int start, int count) {
		if(count == M) {
			fillmap();
			Queue<Point> queue = new LinkedList<>();
			for (int i = 0; i < M; i++) {
				Point tp = virus.get(list[i]);
				queue.add(tp);
				vmap[tp.y][tp.x] = 0;
			}
			int time = 0;
			while(!queue.isEmpty()) {
				isAll = false;
				time++;
				int size = queue.size();
				for (int s = 0; s < size; s++) {
					Point p = queue.poll();
					for (int d = 0; d < 4; d++) {
						int ty = p.y + dy[d];
						int tx = p.x + dx[d];
						
						if(ty < 0 || tx < 0 || ty >= N || tx >= N)
							continue;
						
						if(vmap[ty][tx] == Integer.MAX_VALUE || vmap[ty][tx] == -2) {
							vmap[ty][tx] = time;
							queue.add(new Point(ty, tx));
						}
						
					}
				}
				isAll = isAllVisit();
				if(isAll) {
					min = Math.min(time, min);
					break;
				}
			}
			
			return;
		}
		for (int i = start; i < n; i++) {
			list[count] = i;
			combi(i+1, count+1);
		}
	}
	
	public static void fillmap() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(vmap[i], Integer.MAX_VALUE);
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0)
					vmap[i][j] = map[i][j] * -1;
			}
		}
	}
	public static boolean isAllVisit() {
		boolean is = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(vmap[i][j] == Integer.MAX_VALUE) {
					is = false;
				}
			}
		}
		return is;
	}
	
	public static class Point{
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
}