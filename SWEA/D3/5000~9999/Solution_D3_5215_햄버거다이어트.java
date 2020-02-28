package swea0228;

import java.util.Scanner;


public class Solution_D3_5215_햄버거다이어트 {
	private static int N, L, max;
	private static item[] it;

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			L = sc.nextInt();
			max = 0;

			it = new item[N];

			for (int i = 0; i < N; i++) {
				int score = sc.nextInt();
				int cal = sc.nextInt();

				it[i] = new item(score, cal);
			}

			dfs(0, 0, 0);

			System.out.println("#" + test_case + " " + max);

		}
	}

	public static void dfs(int depth, int score, int cal) {
		if (cal > L)
			return;

		if (depth == N) {
			if (cal <= L)
				if (max < score)
					max = score;
				else
					return;
		} else {
			dfs(depth + 1, score + it[depth].score, cal + it[depth].cal);

			dfs(depth + 1, score, cal);
		}
		return;
	}
}

class item {
	int score;
	int cal;

	public item(int score, int cal) {
		this.score = score;
		this.cal = cal;
	}
}
