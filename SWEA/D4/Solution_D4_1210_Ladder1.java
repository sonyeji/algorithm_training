package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D4_1210_Ladder1 {

	static int[] dx = {-1, 1, 0};
	static int[] dy = {0, 0, -1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int t = sc.nextInt();
			int x = 0;
			int y = 99;
			int[][] ladder = new int[100][100];
			for (int i = 0; i < ladder.length; i++) {
				for (int j = 0; j < ladder.length; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < ladder.length; i++) {
				if(ladder[99][i] == 2) {
					x = i;
					break;
				}
			}
			
			int d = 2;
			
			while(y != 0) {
				if(x-1 >= 0 && ladder[y][x-1] > 0 && d != 1) {
					d = 0;
				}
				else if(x+1 < 100 && ladder[y][x+1] > 0 && d != 0) {
					d = 1;
				}
				int ty = y+dy[d];
				int tx = x+dx[d];
				
				if(tx >= 100 || tx < 0 || ty >= 100 ||
						ty < 0 || ladder[ty][tx] == 0) {
					ty -= dy[d];
					tx -= dx[d];
					d = 2;
					ty = y + dy[d];
					tx = x + dx[d];
				}
				y = ty;
				x = tx;
			}
			
			System.out.println("#" + t + " " + x);
		}
		sc.close();
	}

}
