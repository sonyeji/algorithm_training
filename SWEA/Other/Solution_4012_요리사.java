package com.ssafy.edu;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_4012_요리사 {

	static int N;
	static int R;
	static int[] list;
	static int[][] ingredients;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine().trim());
			R = N/2;
			list = new int[R];
			ingredients = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredients[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			nCr(0, 0);
			
			System.out.println("#" + test_case + " " + min);
		}
		
		
		
	}
	
	public static void nCr(int start, int count) {
		if(count == R) {
			int result = calc(list);
			if(result < min)
				min = result;
			return;
		}
		
		for (int i = start; i < N; i++) {
			list[count] = (i);
			nCr(i+1, count+1);//중복 없는 조합
		}
	}
	
	public static int calc(int[] lists) {
		int firstsum = 0;
		int secondsum = 0;
		
		Set<Integer> first = new TreeSet<>();
		for (int i = 0; i < lists.length; i++) {
			first.add(lists[i]);
		}
		int[] another = getAnother(first);
		
		firstsum = getSum(lists);
		secondsum = getSum(another);
		
		int result = Math.abs(firstsum - secondsum);
		return result;
	}
	public static int getSum(int[] lists) {
		int sum = 0;
		for (int i = 0; i < lists.length; i++) {
			for (int j = 0; j < lists.length; j++) {
				if(i == j) continue;
				sum += ingredients[lists[i]][lists[j]];
			}
		}
		return sum;
	}
	
	public static int[] getAnother(Set<Integer> s) {
		int[] another = new int[R];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(s.contains(i)) continue;
			another[idx] = i;
			idx++;
			if(idx == R) break;
		}
		return another;
	}

}
