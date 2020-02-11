package baek0211;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class baek_1966_printerqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<text> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			for (int i = 0; i < N; i++) {
				int input = sc.nextInt();
				queue.offer(new text(input, i));
				pq.offer(input);
			}
//			PriorityQueue<Integer> rq = new PriorityQueue<Integer>(pq.size(), Collections.reverseOrder());
			int idx = 0;
			boolean ok = false;
			while(true) {
				int max = pq.poll();
				for (int i = 0; i < queue.size(); i++) {
					text now = queue.poll();
					if(now.pri == max) {
						idx++;
						if(now.order == M) {
							ok = true;
							break;
						}
						break;
					}else {
						queue.add(now);
					}
				}
				if(ok)	break;
			}
			System.out.println(idx);
		}
	}
	public static class text{
		int pri;
		int order;
		text(int p, int o){
			pri = p;
			order = o;
		}
	}

}
