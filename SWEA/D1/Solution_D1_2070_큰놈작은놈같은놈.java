package swea0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String mark = "";
			if (a > b)
				mark = ">";
			else if (a < b)
				mark = "<";
			else
				mark = "=";
			System.out.println("#" + (i + 1) + " " + mark);
		}
	}
}
