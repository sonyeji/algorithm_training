package ssafy0211;

import java.util.Scanner;

public class Solution_D3_8104_조만들기 {

	static int K, N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			int[] sum = new int[K];
			int cu = 1;
			boolean ok = true;
			for (int i = 0; i < N; i++) {
				if(ok) {
					for (int j = 0; j < K; j++) {
						sum[j] += cu;
						cu++;
					}
					ok = false;
				}else {
					for (int j = K-1; j >= 0; j--) {
						sum[j] += cu;
						cu++;
					}
					ok = true;
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < sum.length; i++) {
				System.out.print(sum[i] + " ");
			}
			System.out.println();
		}
	}

}
