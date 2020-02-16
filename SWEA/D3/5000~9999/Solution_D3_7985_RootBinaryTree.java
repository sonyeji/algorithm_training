package ssafy0211;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_7985_RootBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
			int len = (int)Math.pow(2, K) - 1;
			int[] list = new int[len];
			for (int i = 0; i < len; i++) {
				list[i] = sc.nextInt();
			}
			
			System.out.print("#" + test_case + " ");
			Queue<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {0, len-1});
			int length = 1;
			int now = 0;
			while(!queue.isEmpty()) {
				int[] cu = queue.poll();
				int s = cu[0];
				int e = cu[1];
				int m = (s+e)/2;
				System.out.print(list[m] + " ");
				now++;
				if(s == e)	continue;
				else {
					queue.add(new int[] {s, m-1});
					queue.add(new int[] {m+1, e});
				}
				if(now == length) {
					System.out.println();
					length *= 2;
					now = 0;
				}
			}
			System.out.println();
		}
	}
}
