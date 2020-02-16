
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4615 {

	static int N, M;
	static int[][] board;

	static int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			board = new int[N][N];
			board[N / 2 - 1][N / 2 - 1] = 2;
			board[N / 2 - 1][N / 2] = 1;
			board[N / 2][N / 2 - 1] = 1;
			board[N / 2][N / 2] = 2;

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				// c == 1 : B, c == 2 : W
				board[y][x] = c;
				check(y, x);
			}

			int sumW = 0;
			int sumB = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						sumB++;
					} else if(board[i][j] ==2){
						sumW++;
					}
				}
			}

			System.out.println("#" + test_case + " " + sumB + " " + sumW);
		}
	}

	public static void check(int y, int x) {
		for (int d = 0; d < 8; d++) {
			int ty = y;
			int tx = x;
			int now = board[ty][tx];
			if (ty + dy[d] < 0 || ty + dy[d] >= N || tx + dx[d] < 0 || tx + dx[d] >= N
					|| board[ty + dy[d]][tx + dx[d]] == 0) {
				continue;
			} else {
				if (board[ty + dy[d]][tx + dx[d]] != now) {
					boolean isblock = false;
					int count = 0;
					while (!(ty + dy[d] < 0 || ty + dy[d] >= N || tx + dx[d] < 0 || tx + dx[d] >= N)) {
						count++;
						if (board[ty + dy[d]][tx + dx[d]] == 0) {
							break;
						}
						if (now == board[ty + dy[d]][tx + dx[d]]) {
							isblock = true;
							break;
						}
						ty += dy[d];
						tx += dx[d];
					}

					if (isblock) {
						ty = y;
						tx = x;
						for (int i = 0; i < count; i++) {
							if (board[ty + dy[d]][tx + dx[d]] != 0 && board[ty + dy[d]][tx + dx[d]] != now)
								board[ty + dy[d]][tx + dx[d]] = now;
							ty += dy[d];
							tx += dx[d];
						}
					}
				}
			}

		}
	}

}
