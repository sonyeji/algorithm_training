package swea0311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로 {

	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static long[][] islands;
	static double E;
	static long[][] graph;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			StringTokenizer xLine = new StringTokenizer(br.readLine());
			StringTokenizer yLine = new StringTokenizer(br.readLine());
			islands = new long[N][2];

			for (int i = 0; i < N; i++) {
				islands[i] = new long[] { Long.parseLong(xLine.nextToken()), Long.parseLong(yLine.nextToken()) };
			}
			E = Double.parseDouble(br.readLine());
			graph = new long[N][N];
			long[] from, to;
			for (int r = 0; r < N; r++) {
				from = islands[r];
				for (int c = r + 1; c < N; c++) {
					to = islands[c];
					graph[c][r] = graph[r][c] = (from[0] - to[0]) * (from[0] - to[0])
							+ (from[1] - to[1]) * (from[1] - to[1]);
				}
			}
			
			double cost = E * prim(0);

			sb.append(Math.round(cost));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static long prim(int start) {
		long cost = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Edge[] dynamicGraph = new Edge[N];
		
		for (int n = 0; n < dynamicGraph.length; n++) {
			dynamicGraph[n] = new Edge(n, Long.MAX_VALUE);
			if(n == start) {
				dynamicGraph[n].cost = 0;
			}
			pq.add(dynamicGraph[n]);
		}
		
		while(!pq.isEmpty()) {
			Edge front = pq.poll();
			cost += front.cost;
			for (int i = 0; i < dynamicGraph.length; i++) {
				Edge child = dynamicGraph[i];
				if(pq.contains(child)) {
					long tempCost = graph[front.idx][child.idx];
					if(tempCost < child.cost) {
						child.cost = tempCost;
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		
		return cost;
	}

	static class Edge implements Comparable<Edge>{
		int idx;
		long cost;
		public Edge(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "idx=" + idx + ", cost=" + cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
}
