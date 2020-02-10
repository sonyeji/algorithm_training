package baek0210;

import java.util.Arrays;
import java.util.Scanner;

public class baek_2798_∫Ì∑¢¿Ë {

	static int N, M;
	static int R = 3;
	static int[] card;
	static int max = 0;
	static int[] list = new int[3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		card = new int[N];

		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}

		nCr(0, 0);
		
		System.out.println(max);
	}

	public static void nCr(int start, int count) {
		if(count == R) {
			int sum = sum(list);
			if(sum > max)
				max = sum;
			return;
		}
		for(int i = start; i < N; i++) {
			list[count] = card[i];
			nCr(i+1, count+1);
		}
	}
	
	public static int sum(int[] l) {
		int sum = 0;
		for (int i = 0; i < l.length; i++) {
			sum += l[i];
		}
		if(sum > M)	return 0;
		return sum;
	}
}
