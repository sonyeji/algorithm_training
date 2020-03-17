package swea0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D5_1812_수정이의타일자르기 {
	static class Rectangle implements Comparable<Rectangle>{
		int min, max;
		public Rectangle(int width, int height) {
			if(height > width) {
				min = width;
				max = height;
			}else {
				min = height;
				max = width;
			}
		}
		@Override
		public int compareTo(Rectangle o) {
			// TODO Auto-generated method stub
			return o.min - this.min;
		}
	}
	
	static int N, M, size[], cnt;
	static PriorityQueue<Rectangle> queue;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			size = new int[N];
			cnt = 0;
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				size[i] = Integer.parseInt(st.nextToken());
			}
			
			cut();
			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void cut() {
		Arrays.sort(size);
		queue = new PriorityQueue<>();
		queue.offer(new Rectangle(M, M));
		++cnt;
		for (int i = N-1; i >= 0; i--) {
			go(1<<size[i]);
		}
	}

	private static void go(int size) {
		Rectangle r = queue.poll();
		if(r.min>=size) {
			queue.offer(new Rectangle(r.min-size, size));
			queue.offer(new Rectangle(r.min, r.max-size));
		}else{
			queue.offer(r);
			queue.offer(new Rectangle(M-size, size));
			queue.offer(new Rectangle(M, M-size));
			++cnt;
		}
	}
}
