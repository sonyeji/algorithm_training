package baek0210;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2667_단지번호{

	
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int d;
	
	public static class Com implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new char[N][N];
		visit = new boolean[N][N];
		int num = 0;
		ArrayList<Integer> count = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			map[i] = s.toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '1' && !(visit[i][j])) {
					count.add(bfs(i, j));
					num++;
				}
			}
		}
		System.out.println(num);
		count.sort(new Com());
		for (int i = 0; i < num; i++) {
			System.out.println(count.get(i));
		}
	}
	
	
	
	public static int bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		visit[i][j] = true;
		int count = 1;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int tx = p.x + dx[d];
				int ty = p.y + dy[d];
				
				if(tx >= 0 && ty >= 0 && tx < visit.length && ty < visit.length
						&& map[ty][tx] == '1' && visit[ty][tx] == false) {
					queue.add(new Point(ty,tx));
					visit[ty][tx] = true;
					count++;
				}
			}
		}
		return count;
	}
	
	public static class Point{
		int x;
		int y;
		Point(int y, int x){
			this.x = x;
			this.y = y;
		}
	}

}