package swea0221;


import java.util.Scanner;

public class Solution_D3_9480_¾ËÆÄºª°øºÎ {

	static String[] input;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			max = 0;
			input = new String[N];
			for (int i = 0; i < N; i++) {
				input[i] = sc.next().trim();
			}
			
			for (int i = 1; i <= N; i++) {
				nCr(N, i, 0, 0, new int[i]);
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void nCr(int n, int r, int start, int count, int[] list) {
		if(count == r) {
			if(check(list)) {
				max++;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			list[count] = i;
			nCr(n, r, i+1, count+1, list);
		}
	}
	
	public static boolean check(int[] list) {
		int[] alpha = new int[26];
		for (int i = 0; i < list.length; i++) {
			char[] word = input[list[i]].toCharArray();
			for (int j = 0; j < word.length; j++) {
				alpha[word[j]-'a']++;
			}
		}
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i] == 0)
				return false;
		}
		return true;
	}

}
