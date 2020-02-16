package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_baek_17136 {
	static int[][] map;
	static int[] paper = { 5, 5, 5, 5, 5 };

	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 0, 1 };

	static int num;
	
	static PriorityQueue<rec> queue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		map = new int[10][10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		num = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int cnt = search(i, j);
//				if (cnt == 0)
//					continue;
//				stick(i, j, cnt);
//				if (paper[cnt - 1] < 0) {
//					num = -1;
//					break;
//				}
			}
		}
		System.out.println(num);
	}

	public static void stick(int y, int x, int cnt) {
		for (int i = y; i < y + cnt; i++) {
			for (int j = x; j < x + cnt; j++) {
				map[i][j] = 2;
			}
		}
//		System.out.println(y + ", " + x);
		paper[cnt - 1]--;
		num++;
	}

	public static int search(int y, int x) {
		int cc = 50;
		int ty = y;
		int tx = x;
		if (map[ty][tx] == 1) {
			for (int d = 0; d < 3; d++) {
				int cnt = 1;
				ty = y;
				tx = x;
				while (true) {
					if (isOut(ty + dy[d], tx + dx[d]))
						break;
					ty += dy[d];
					tx += dx[d];
					if (map[ty][tx] == 1) {
						cnt++;
					}else {
						break;
					}
				}
				if (cnt < cc)
					cc = cnt;
				if (cnt == 1) {
					queue.add(new rec(y, x, y, x));
					return 1;
				}
			}
		}
		if (cc == 50)
			return 0;
		else {
			queue.add(new rec(y, x, y+cc, x+cc));
			return cc;
		}
	}

	public static boolean isOut(int y, int x) {
		if (y < 0 || x < 0 || y >= 10 || x >= 10) {
			return true;
		} else {
			return false;
		}
	}
	public static class rec{
		int sy;
		int sx;
		int ey;
		int ex;
		
		rec(int sy, int sx, int ey, int ex){
			this.sy = sy;
			this.sx = sx;
			this.ey = ey;
			this.ex = ex;
		}
	}
}
