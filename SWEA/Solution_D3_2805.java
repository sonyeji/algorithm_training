import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine().trim());
			long value = 0L;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				char[] list = st.nextToken().trim().toCharArray();
				for (int j = 0; j < list.length; j++) {
					map[i][j] = (int) (list[j] - '0');
				}
			}
			int k = 1;
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < k; j++) {
					int tmp = N/2 - i + j;
					value += map[i][N/2 - i + j];
					tmp = N /2 - i + j;
					value += map[N - 1 - i][N / 2 - i + j];
				}
				k += 2;
				value += (map[N / 2][i] + map[N / 2][N -1 -i]);
			}
			
			System.out.println("#" + test_case + " " + (value + map[N/2][N/2]));
		}
	}

}
