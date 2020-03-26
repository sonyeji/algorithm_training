package swea0326;

import java.util.Scanner;

public class Solution_D4_7465_창용마을 {

	private static int N;
	private static int M;
	public static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			M = sc.nextInt();
			parent = new int[N+1];
			for (int i = 0; i < N+1; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < M; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				union(s, e);
			}
			System.out.println("#" + tc + " " + uniNum());
		}
		
		sc.close();
	}
	
	public static int find(int x) {
        if(x == parent[x])
            return x;
        else 
            return parent[x] = find(parent[x]);
	}
	
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 같은 부모를 가지고 있지 않을 때
        if(x != y) {
            // y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
            parent[y] = x;
        }
    }
    
    public static int uniNum() {
    	int num = 0;
    	for (int i = 1; i < N+1; i++) {
			if(parent[i] == i) {
				num++;
			}
		}
    	return num;
    }

}
