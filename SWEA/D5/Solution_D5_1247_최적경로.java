package swea0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	static int N;
	static int[] x;
	static int[] y;
	static int[][] map;
	static int min;
	static int[] list;
	static boolean[] visit;

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			min = Integer.MAX_VALUE;
			x = new int[2 + N];
			y = new int[2 + N];
			map = new int[2 + N][2 + N];
			visit = new boolean[2 + N];
			list = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[0] = Integer.parseInt(st.nextToken());
			y[0] = Integer.parseInt(st.nextToken());
			x[1 + N] = Integer.parseInt(st.nextToken());
			y[1 + N] = Integer.parseInt(st.nextToken());

			for (int i = 1; i < N + 1; i++) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			makeMap();
			nPr(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static void nPr(int flag, int count) {
		if (count == N) {
			getValue();
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				list[count] = i + 1;
				nPr(flag | 1 << i, count + 1);
			}
		}
	}

	static void makeMap() {
		for (int i = 0; i < map.length - 1; i++) {
			for (int j = i + 1; j < map.length; j++) {
				map[i][j] = Math.abs((x[i] - x[j])) + Math.abs((y[i] - y[j]));
				map[j][i] = map[i][j];
			}
		}
	}

	static void getValue() {
		int val = map[0][list[0]];
		for (int i = 0; i < list.length - 1; i++) {
			val += map[list[i]][list[i + 1]];

		}
		val += map[list[N - 1]][N + 1];
		min = Math.min(min, val);
	}

}
