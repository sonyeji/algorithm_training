package swea0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2072_홀수만더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[10];
			sum = 0;
			for (int j = 0; j < 10; j++) {
				list[j] = Integer.parseInt(st.nextToken());
				if (list[j] % 2 == 1) {
					sum += list[j];
				}
			}
			System.out.println("#" + i + " " + sum);
		}

	}
}
