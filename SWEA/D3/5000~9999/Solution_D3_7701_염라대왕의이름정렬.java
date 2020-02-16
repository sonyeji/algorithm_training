package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Solution_D3_7701_염라대왕의이름정렬 {

	public static class OHC implements Comparator<String>{
		
		@Override
		public int compare(String o1, String o2) {
			if(o1.length() > o2.length()){
				return 1;
			}else if(o1.length() < o2.length()) {
				return -1;
			}else {
				return o1.compareTo(o2);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			Set<String> set = new TreeSet<>();
			LinkedList<String> names = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine().trim();
				set.add(input);
			}
			
			
			for(Iterator<String> it = set.iterator(); it.hasNext();) {
				names.add(it.next());
			}
			
			names.sort(new OHC());
			
			System.out.println("#" + test_case);
			
			for(String a: names) {
				System.out.println(a);
			}
			
		}
	}

}
