import java.util.Scanner;

public class Solution_D3_1873 {

	static char[][] map;
	static int H, W;
	static int d = 0;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int y, x;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			y = 0;
			x = 0;
			for (int i = 0; i < H; i++) {
				String input = sc.next();
				for (int j = 0; j < W; j++) {
					char c = input.charAt(j);
					map[i][j] = c;
					if (c == '<' || c == '^' || c == '>' || c == 'v') {
						y = i;
						x = j;
						if(c == '<')	d = 2;
						else if(c == '^')	d = 0;
						else if(c == '>')	d = 3;
						else	d = 1;
					}
				}
			}

			int N = sc.nextInt();
			String input = sc.next();
			for (int i = 0; i < N; i++) {
				char op = input.charAt(i);
				go(y, x, op);
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static void go(int ty, int tx, char op) {
		char di = '<';
		if(op == 'S')
			shoot(ty, tx);
		else {
			if (op == 'U') {
				di = '^';
				d = 0;
			} else if (op == 'D') {
				di = 'v';
				d = 1;
			} else if (op == 'L') {
				di = '<';
				d = 2;
			} else if (op == 'R') {
				di = '>';
				d = 3;
			}
			map[ty][tx] = di;
			if(!isOut(ty+dy[d], tx+dx[d]) && map[ty+dy[d]][tx+dx[d]] == '.') {
				map[ty][tx] = '.';
				map[ty+dy[d]][tx+dx[d]] = di;
				y = ty+dy[d];
				x = tx+dx[d];
			}
		}
	}

	public static void shoot(int ty, int tx) {
		if(isOut(ty + dy[d], tx + dx[d]))	return;
		if (map[ty + dy[d]][tx + dx[d]] == '*') {
			map[ty + dy[d]][tx + dx[d]] = '.';
			return;
		} else if (map[ty + dy[d]][tx + dx[d]] == '#') {
			return;
		} else {
			shoot(ty + dy[d], tx + dx[d]);
		}
	}

	public static boolean isOut(int y, int x) {
		if (y < 0 || x < 0 || y >= H || x >= W) {
			return true;
		} else {
			return false;
		}
	}

}
