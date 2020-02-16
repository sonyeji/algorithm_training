package com.ssafy.edu;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_5948_새샘이2 {

	static LinkedList<Integer> set = new LinkedList<>();
	static int[] game;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			set.clear();
			game = new int[7];
			for (int i = 0; i < game.length; i++) {
				game[i] = sc.nextInt();
			}
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = i+1; j < 7; j++) {
					for (int k = j+1; k < 7; k++) {						
						if(i < j && j < k && i < k) {
							sum = game[i] + game[j] + game[k];
							if(!set.contains(sum))
								set.add(sum);
						}
					}
				}
			}
			
			set.sort(new Com());
			System.out.println("#" + test_case + " " + set.get(4));
		}
	}
	
	public static class Com implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return -(o1-o2);
		}
		
	}
}
