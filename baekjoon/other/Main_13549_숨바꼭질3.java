package baek0221;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13549_¼û¹Ù²ÀÁú3 {
	static int K;
	static int[] visited;
	static int len = 100001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		visited = new int[len];
		Arrays.fill(visited, Integer.MAX_VALUE);
		if (N >= K) {
			System.out.println(N - K);
			return;
		}

		go(N, 0);
		System.out.println(visited[K]);
	}

	public static void go(int n, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { n, c });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if (tmp[0] > len - 1 || tmp[0] < 0) {
				continue;
			}
			if (visited[tmp[0]] < tmp[1])
				continue;
			visited[tmp[0]] = tmp[1];
			if (tmp[0] == K)
				return;
			if (tmp[0] * 2 < len && tmp[0] != 0) {
				if (visited[tmp[0]*2] == Integer.MAX_VALUE)
					for (int i = tmp[0] * 2; i < len; i *= 2) {
						if (visited[i] < tmp[1])
							continue;
						visited[i] = tmp[1];
						queue.add(new int[] { i, tmp[1] });
					}
			}
			queue.add(new int[] { tmp[0] - 1, tmp[1] + 1 });
			queue.add(new int[] { tmp[0] + 1, tmp[1] + 1 });
		}
	}
}
