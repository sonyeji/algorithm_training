package swea0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_swtest_2115_벌꿀채취 {

	static int N, M, C;
	static int[][] map, maxMap;

	// map:입력된 벌통정보
	// maxMap : i, j위치에서 가질 수 있는 최대 이익
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			makeMaxMap();
			System.out.println("#" + tc + " " + getMaxBenefit());
		}
	}

	static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}

	// i : 행, j : 열, cnt:고려한 원소 수
	// sum : 부분집합에 속한 원소 합
	// powSum : 부분집합에 속한 원소 이익
	static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		if (sum > C)
			return;

		if (cnt == M) {
			// 0,0:0 0,1:1, 0,2:2
			if (maxMap[i][j - M] < powSum) {
				maxMap[i][j - M] = powSum;
			}
			return;
		}

		// 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);

		// 비선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum);
	}

	static int getMaxBenefit() {
		int max = 0, temp = 0;
		// 일꾼 a 기준 선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				// 일꾼 b 선택
				// 같은 행 기준 선택
				for (int j2 = j + M; j2 <= N - M; j2++) {
					temp = maxMap[i][j] + maxMap[i][j2];
					if (max < temp) {
						max = temp;
					}
				}

				// 다음행부터 마지막행 까지 선택
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N - M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if (max < temp) {
							max = temp;
						}
					}
				}

			}
		}

		return max;
	}
}
