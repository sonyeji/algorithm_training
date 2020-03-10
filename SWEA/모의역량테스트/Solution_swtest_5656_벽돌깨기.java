package swea0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swtest_5656_벽돌깨기 {

	static StringBuilder sb = new StringBuilder();
	static int[][] dirs = {{-1, 0},{1, 0},{0, 1},{0, -1}};
	static int T, N, C, R;
	static int brickCnt;
	static int answer;
	static int[][] map;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			map = new int[R][C];
			brickCnt = 0;
			
			for (int r = 0; r < R; r++) {
				tokens = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(map[r][c] != 0) {
						brickCnt++;
					}
				}
			}
			answer = brickCnt;
			
//			for (int [] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			dropMarble(N, brickCnt, map);
			
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void dropMarble(int r, int brickCnt, int[][] map) {
		if(r==0) {
			//솔루션 사용
			answer = Math.min(answer, brickCnt);
			return;
		}
		for (int c = 0; c < C; c++) {
			// 1. map의 복제
			int[][] cloned = cloneMap(map);
			//2. 해당 컬럼의 맨 처음 벽돌 가져오기
			Brick first = getFirstBrick(c, cloned);
			//2-1 null -> continue;
			if(first == null)
				continue;
			//3. 구슬을 떨어뜨려서 벽돌을 깬다. --> 깨진 벽돌 수?
			int broken = crash(first, cloned);
			//3-1. 이미 벽돌이 다 깨졌다면? --> 정답 = 0, 종료
			if(broken >= brickCnt) {
				answer = 0;
				return;
			}
			//4. 화면정리
			cleanMap(cloned);
			//5. 다음 샷 발사
			dropMarble(r-1, brickCnt-broken, cloned);
		}
	}
	private static void cleanMap(int[][] map) {
		for (int c = 0; c < C; c++) {
			for (int r = R-1, nr = R-1; r >= 0; r--) {
				if(map[r][c] != 0) {
					int temp = map[r][c];
					map[r][c] = 0;
					map[nr--][c] = temp;
				}
			}
		}
	}
	private static int crash(Brick first, int[][] map) {
		int broken = 0;
		map[first.row][first.col] = 0;
		broken++;
		
		for (int p = 1; p < first.pow; p++) {
			for (int d = 0; d < 4; d++) {
				int nr = first.row + dirs[d][0] * p;
				int nc = first.col + dirs[d][1] * p;
				
				if(isIn(nr, nc) && map[nr][nc] != 0) {
					broken += crash(new Brick(nr, nc, map[nr][nc]), map);
				}
			}
		}
		return broken;
	}
	
	private static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < R && c < C;
	}
	
	private static Brick getFirstBrick(int c, int[][] map) {
		for (int r = 0; r < R; r++) {
			if(map[r][c] != 0) {
				return new Brick(r, c, map[r][c]);
			}
		}
		return null;
	}
	
	private static int[][] cloneMap(int[][] map) {
		int[][] temp = new int[R][C];
		for(int r = 0 ; r < R; r++) {
			temp[r] = map[r].clone();
		}
		return temp;
	}

	static class Brick{
		int row, col, pow;

		public Brick(int row, int col, int pow) {
			super();
			this.row = row;
			this.col = col;
			this.pow = pow;
		}

		@Override
		public String toString() {
			return "[row=" + row + ", col=" + col + ", pow=" + pow + "]";
		}
		
	}
}
