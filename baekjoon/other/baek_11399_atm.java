package baek0210;

import java.util.Arrays;
import java.util.Scanner;

public class baek_11399_atm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] times = new int[N];
		for (int i = 0; i < N; i++) {
			times[i] = sc.nextInt();
		}
		
		Arrays.sort(times);
		int result = 0;
		for (int i = 0; i < times.length; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += times[j];
			}
			result += sum;
		}
		System.out.println(result);
	}

}
