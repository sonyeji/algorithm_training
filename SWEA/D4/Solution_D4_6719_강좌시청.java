package swea0221;


import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_6719_°­ÁÂ½ÃÃ» {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			double A = 0.000000;
			double[] list = new double[N];
			for (int i = 0; i < N; i++) {
				list[i] = sc.nextInt();
			}
			
			Arrays.sort(list);
			for (int i = N - K; i <= N-1; i++) {
				A = (A + list[i]) / 2.000000;
			}
			
			
			System.out.println("#" + tc + " " + A);
		}
	}

}
