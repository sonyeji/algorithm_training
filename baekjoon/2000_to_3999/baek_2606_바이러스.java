package baek0210;

import java.util.Scanner;

public class baek_2606_바이러스 {

	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		
		int[][] graph = new int[N+1][N+1];
		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		int[] virus = new int[N+1];
		visited = new boolean[N+1];
		int v = 1;
		dfs(graph, v);
		int sum = 0;
		for (int i = 1; i < visited.length; i++) {
			if(visited[i] == true)
				sum++;
		}
		System.out.println(sum-1);
	}
	
	public static void dfs(int[][] graph, int V) {
		visited[V] = true;
		for (int i = 1; i < graph.length; i++) {
			if(visited[i] || graph[V][i] == 0) {
				continue;
			}
			dfs(graph, i);
		}
	}

}
