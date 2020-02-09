package greedy;

public class sweatsuit {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		System.out.println(solution(5, lost, reserve));

	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int[] list = new int[n];
		for(int i = 0; i < n; i++) list[i] = 1;
		for(int i = 0; i < reserve.length; i++) list[reserve[i]-1]++;
		for(int i = 0; i < lost.length; i++) list[lost[i]-1]--;
		
        int answer = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] == 0) {
            	if(i == 0) {
            		if(list[i+1] == 2) {
            			list[i]++;
            			list[i+1]--;
            		}
            	}else {
            		if(list[i-1] == 2) {
            			list[i-1]--;
            			list[i]++;
            		}else if(i+1 < list.length && list[i+1] == 2) {
            			list[i]++;
            			list[i+1]--;
            		}
            	}
            }
            else	continue;
        }
        
        for(int i = 0; i < list.length; i++) {
        	if(list[i] >= 1) answer++;
        }
        
        return answer;
    }
}
