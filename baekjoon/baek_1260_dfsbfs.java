package baek0210;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_1260_dfsbfs {

	static int[] visit_d;
    static int[] visit_b;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N, M, V;
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        
        int[][] graph = new int[N+1][N+1];
        visit_d = new int[N+1];
        visit_b = new int[N+1];
        
        for(int i = 0; i < M; i++) {
        	int s = sc.nextInt();
        	int e = sc.nextInt();
        	
        	graph[s][e] = 1;
        	graph[e][s] = 1;
        }
        
        dfs(graph, V);
        System.out.println();
        bfs(graph, V);
	}
	
	public static void dfs(int[][] graph, int v) {
		System.out.print(v + " ");
		visit_d[v] = 1;
		
		for(int i=1; i<=graph.length-1; i++) {
	        if(visit_d[i] == 1 || graph[v][i] == 0)     
	            continue;
	        dfs(graph, i);
	    }
	}
	
	public static void bfs(int[][] graph, int v) {
		visit_b[v] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);

		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			
			for (int i = 1; i <= graph.length-1; i++) {
				if (graph[v][i] == 1 && visit_b[i] == 0) {
					q.add(i);
					visit_b[i] = 1;
				}
			}
		}
	}
}
