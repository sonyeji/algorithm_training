package ssafy0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static int N, W, H;
	static int[][] map;
	static int min;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
			
			
			bomb(1, 2);
			down();
			print();
			bomb(2, 2);
			down();
			print();
			bomb(8, 6);
			down();
			print();
			
			
			System.out.println("#" + test_case + " " + min);
		}
	}
	
	public static void simul(int bNum) {
		
	}
	
	public static void bomb(int y, int x) {
		int count = map[y][x];
		map[y][x] = 0;
		if(count == 1)	return;
		for (int d = 0; d < 4; d++) {
			int ty = y;
			int tx = x;
			for (int i = 1; i < count; i++) {
				ty += dy[d];
				tx += dx[d];
				if(ty < 0 || ty >= H || tx < 0 || tx >= W)	break;
				if(map[ty][tx] == 0)	continue;
				bomb(ty, tx);
			}
		}
	}
	
	public static void print() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void down() {
		for (int j = 0; j < W; j++) {
			for (int i = H-1; i >= 0; i--) {
				if(map[i][j] == 0) {
					for (int k = i-1; k >= 0; k--) {
						if(map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	public static int ballDown(int x) {
		for (int i = 0; i < H; i++) {
			if(map[i][x] != 0) return i;
		}
		return -1;
	}

}
