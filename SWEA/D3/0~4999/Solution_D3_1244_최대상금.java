package com.ssafy.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Solution_D3_1244_최대상금 {

	static int trans;
	static ArrayList<Integer> list;
	static int max;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] input = sc.next().toCharArray();
			trans = sc.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				list.add(input[i] - '0');
			}
			max = 0;
			change(0, 0, list);
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void change(int count, int now, ArrayList<Integer> board) {
		if(count == trans) {
			int sum = getSum(board);
			max = Math.max(sum, max);
			return;
		}
		for (int i = 0; i < board.size(); i++) {
			if(i == now)	continue;
			int tmp = board.get(now);
			board.replaceAll(operator);
			board[now] = board[i];
			board[i] = tmp;
			for (int j = 0; j < board.length; j++) {
				if(now+j >= board.length)	continue;
				change(count+1, now+j, board);		
			}
			tmp = board[now];
			board[now] = board[i];
			board[i] = tmp;
		}
	}

	public static int getSum(int[] board) {
		int num = 1;
		int sum = 0;
		for (int i = board.length-1; i >= 0; i--) {
			sum += board[i]*num;
			num *= 10;
		}
		return sum;
	}
}
