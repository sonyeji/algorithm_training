package ssafy0211;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek_15651 {

	static int N, R;
	static int[] list;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		list = new int[R];
		nPr(0, 0, bw);
		bw.close();
	}

	public static void nPr(int flag, int count, BufferedWriter bw) throws Exception {
		if(count == R) {
			for (int i = 0; i < R; i++) {
				bw.write(list[i] + " ");
			}
			bw.newLine();
			return;
		}
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i) == 0) {
				list[count] = i+1;
				nPr(flag & 1<<i, count+1, bw);
			}
		}
	}
}
