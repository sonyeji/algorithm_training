package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_D3_1229_암호문2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String token = st.nextToken();
				
				if(token.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					int[] s = new int[y];
					for (int j = 0; j < y; j++) {
						s[j] = Integer.parseInt(st.nextToken());
					}
					for (int j = y-1; j >= 0; j--) {
						list.add(x, s[j]);
					}
				}else {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
