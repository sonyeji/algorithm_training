package ssafy0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D4_3347_올림픽 {

	static int N;
	static int M;
	static int[] A;
	static int[] B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			A = new int[N];
			B = new int[M];
			
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			int[] count = new int[N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(B[i] >= A[j]) {
						count[j]++;
						break;
					}
				}
			}
			int max = 0;
			int maxidx = 0;
			for (int i = 0; i < count.length; i++) {
				if(count[i] > max) {
					max = count[i];
					maxidx = i;
				}
			}
			System.out.println("#" + test_case + " " + (maxidx+1));
		}
	}

}
