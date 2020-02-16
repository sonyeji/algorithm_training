package com.ssafy.edu;

import java.time.format.TextStyle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution_D3_5948_새샘이 {

	static int N = 7;
	static int R = 3;
	static int[] list = new int[R];
	static int[] com = new int[N];
	static Set<Integer> set = new TreeSet<>();
	static boolean[] isc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			set.clear();
			int result = 0;
			isc = new boolean[N];
			
			for (int i = 0; i < 7; i++) {
				com[i] = sc.nextInt();
			}
			
			nCr(0, 0);
			LinkedList<Integer> sums = new LinkedList<>();
			for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
				sums.add(it.next());
			}
			
			System.out.println("#" + test_case + " " + sums.get(sums.size()-5));
		}
	}
	
	public static void nCr(int start, int count) {
		if(count == R) {
			int s = 0;
			for (int i = 0; i < isc.length; i++) {
				if(isc[i]) {
					s+=com[i];
				}
			}
			set.add(s);
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(!isc[i]) {
				isc[i] = true;
				nCr(i+1, count+1);
				isc[i] = false;
			}
		}
	}

}
