package baek0211;

import java.util.Scanner;

public class baek_3985_롤케이크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] P = new int[N];
		int[] K = new int[N];
		int[] cake = new int[L];
		int[] real = new int[N];
		int hmax = 0;
		int hidx = 0;
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt() - 1;
			K[i] = sc.nextInt() - 1;
			if(hmax < K[i] - P[i] + 1) {
				hmax = K[i] - P[i] + 1;
				hidx = i + 1;
			}
		}

		for (int i = 0; i < N; i++) {
			int s = P[i];
			int e = K[i];
			int count = 0;
			for (int j = s; j <= e; j++) {
				if (cake[j] == 0) {
					cake[j] = i + 1;
					count++;
				}
			}
			real[i] = count;
		}
		int rmax = 0;
		int ridx = 0;
		for (int i = 0; i < real.length; i++) {
			if(real[i] > rmax) {
				rmax = real[i];
				ridx = i + 1;
			}
		}

		System.out.println(hidx);
		System.out.println(ridx);
	}

}
