import java.util.Arrays;

//무방향 그래프
//visit 만들어서 0일 떄마다 깊우탐
//깊우탐 들어갈 떄마다 answer+1

public class Solution {
	
	static boolean[] visit;
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        //자기 자신 위치 0으로 변경 (1->0)
        for(int i = 0; i<n; i++) {
        	computers[i][i] = 0;
        }
        
        for(int i = 0; i<n; i++) {
        	if(!visit[i]) {
        		visit[i] = true;
        		answer++;
                DFS(computers, n, i); 
        	}
        }
        
        return answer;
    }
	
	private static void DFS(int[][] computers, int n, int nodeNum) {
		
		for(int i = 0; i<n; i++) {
			if(computers[nodeNum][i] == 1 && !visit[i]) {
				visit[i] = true;
				DFS(computers, n, i);
			}
		}
	}
	
	public static void main(String[] args) {

		int n = 3;
		int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
		
		solution(n, computers);
		
	}

}
