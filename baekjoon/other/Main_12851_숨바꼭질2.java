package baek0221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_12851_¼û¹Ù²ÀÁú2 {

	static int K;
	static int[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		visited = new int[200000+1][2];
		for (int i = 0; i < 200000; i++) {
			visited[i][0] = Integer.MAX_VALUE;
		}
		go(N, 0);
		System.out.println(visited[K][0]);
		System.out.println(visited[K][1]);
	}
	
	public static void go(int n, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{n, c});
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(tmp[0]>200000 || tmp[0] < 0) {
				continue;
			}
			if(visited[tmp[0]][0] < tmp[1]) continue;
			visited[tmp[0]][0] = tmp[1];
			visited[tmp[0]][1]++;
			if(tmp[0] == K)	continue;
			queue.add(new int[] {tmp[0]-1, tmp[1]+1});
			queue.add(new int[] {tmp[0]+1, tmp[1]+1});
			queue.add(new int[] {tmp[0]*2, tmp[1]+1});
		}
	}

}