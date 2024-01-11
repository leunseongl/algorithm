import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        boolean[][] dist = new boolean[n][n];
        for(int i = 0; i<results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            
            dist[a-1][b-1] = true;
        }
        
        for(int k = 0; k<n; k++) {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(dist[i][k] && dist[k][j]) dist[i][j] = true;
                }
            }
        }
        
        int[] cnt = new int[n];
        for(int  i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(dist[i][j] || dist[j][i]) cnt[i]++;
            }
        }
        
        int answer = 0;
        for(int c: cnt) {
            if(c == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}