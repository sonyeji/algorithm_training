package ssafy0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15651_2 {

	static int N, R;
	static int[] list = {1, 2, 3, 4, 5, 6, 7};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		//list = new int[R];
		nPr(0);
	}
	
	public static void nPr(int count) {
		if(count == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(list[i]);
			}
			System.out.println();
			return;
		}
		for (int i = count; i < N; i++) {
			int temp = list[count];
			list[count] = list[i];
			list[i] = temp;
			nPr(count+1);
			temp = list[count];
			list[count] = list[i];
			list[i] = temp;
		}
	}
}
