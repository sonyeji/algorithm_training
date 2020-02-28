package swea0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D1_2058_자릿수더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] list = input.split("");
		int sum = 0;
		for (int i = 0; i < list.length; i++) {
			sum += Integer.parseInt(list[i]);
		}
		System.out.println(sum);
	}
}
