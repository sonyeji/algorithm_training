package swea0229;

import java.util.Scanner;

public class Solution_swtest_7208_지도칠하기 {

	static int N; //node num
	static int M; //color num
	static int[] colors;
	static int[] vcolor;
	static int[][] map;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = 4;
			colors = new int[N];
			vcolor = new int[N];
			map = new int[N][N];
			vcolor[0] = 1;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				colors[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int t = sc.nextInt();
					map[i][j] = t;
				}
			}
			m_coloring(0);
			System.out.println("#" + tc + " " + min);

		}
		sc.close();
	}
	
	static boolean promising(int i){
        int j = 0;
        boolean stc = true;
         
        while ( j < i && stc ){
            if( map[i][j] == 1 && vcolor[i] == vcolor[j] ) stc = false;
            j++;
        }
        return stc;
    }
     
    static void m_coloring(int i){
        int color;
        if ( promising(i) )
            if ( i == N-1 ){
            	int diff = 0;
            	for (int j = 0; j < N; j++) {
					if(vcolor[j] != colors[j]) {
						diff++;
					}
				}
            	min = Math.min(min, diff);
            }else{
                for ( color = 1; color <= M ; color++ ){
                    vcolor[i+1] = color;
                    m_coloring(i+1);
                }
            }
    }
}
