package algorithm_sort;

import java.util.Arrays;

public class k_number {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println(solution(array, commands));

	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int len = commands.length;
        answer = new int[len];
        
        for(int i = 0; i < len; i++) {
        	int[] newarr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
        	Arrays.sort(newarr);
        	answer[i] = newarr[commands[i][2]-1];
        }
        
        return answer;
    }
}
