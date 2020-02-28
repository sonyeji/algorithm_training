package swea0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2068_최대수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			for (int j = 0; j < 10; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (max < temp)
					max = temp;
			}
			System.out.println("#" + (i + 1) + " " + max);
		}
	}
}
