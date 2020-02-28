package swea0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D1_2063_중간값찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] list = new int[num];
		for (int i = 0; i < num; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		int mid = 0;

		Arrays.sort(list);

		mid = list[list.length / 2];
		System.out.println(mid);
	}
}
