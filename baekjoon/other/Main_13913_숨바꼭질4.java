package baek0221;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_13913_¼û¹Ù²ÀÁú4 {
	static int K;
	static int[][] visited;//0:count, 1:pre
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		visited = new int[100000+1][2];
		for (int i = 0; i <= 100000; i++) {
			visited[i][0] = Integer.MAX_VALUE;
		}
		go(N, -1);
		System.out.println(visited[K][0]);
		Stack<Integer> pres = new Stack<Integer>();
		int pre = K;
		pres.add(pre);
		for (int i = 0; i < visited[K][0]; i++) {
			pre = visited[pre][1];
			pres.add(pre);
		}
		while(!pres.isEmpty()) {
			System.out.print(pres.pop() + " ");
		}
	}
	
	public static void go(int n, int r) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(n, r));
		
		int count = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point tmp = queue.poll();
				if(tmp.p>100000 || tmp.p < 0) {
					continue;
				}
				if(visited[tmp.p][0] != Integer.MAX_VALUE) continue;
				visited[tmp.p][0] = count;
				visited[tmp.p][1] = tmp.pre;
				if(tmp.p == K)	return;
				queue.add(new Point(tmp.p-1, tmp.p));
				queue.add(new Point(tmp.p+1, tmp.p));
				queue.add(new Point(tmp.p*2, tmp.p));
			}
			count++;
		}
	}
	
	public static class Point{
		int p;
		int pre;
		
		Point(int p, int pre){
			this.p = p;
			this.pre = pre;
		}

		@Override
		public String toString() {
			return "p=" + p + ", pre=" + pre;
		}
	}		
}
