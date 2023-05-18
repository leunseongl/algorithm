import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    static int N, M;
    static int[][] paper;
    static boolean[][] visit;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        paper = new int[N][M];
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력 완료
        
        visit = new boolean[N][M];
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visit[i][j] = false;
                //ㅓ ㅏ ㅗ ㅜ
                check(i, j);
            }
        }
        
        System.out.println(answer);
        
    }

    private static void dfs(int x, int y, int depth, int sum) {
        
        //기저 조건
        if(depth == 4) {
            //합의 최댓값 찾기 처리 로직
            answer = sum>answer?sum:answer;
            //System.out.println("sum은 " + sum);
            return;
        }
        
        for(int k = 0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            //경계선 조건
            if(nx>=0 && nx<N && ny>=0 && ny<M) {
                if(!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dfs(nx, ny, depth+1, sum+paper[nx][ny]);
                    visit[nx][ny] = false;
                }
            }
        }
    }
    
    private static void check(int x, int y) {
    	
    	//ㅏ
    	if(x+1<N && x+2<N && y+1<M) {
	    	if(paper[x][y] + paper[x+1][y] + paper[x+2][y] + paper[x+1][y+1] > answer) {
	    		int tmp = paper[x][y] + paper[x+1][y] + paper[x+2][y] + paper[x+1][y+1];
	    		answer = tmp;
	    	}
    	}
    	
    	//ㅓ 
    	if(x+1<N && x+2<N && y-1>=0) {
	    	if(paper[x][y] + paper[x+1][y] + paper[x+2][y] + paper[x+1][y-1] > answer) {
	    		int tmp = paper[x][y] + paper[x+1][y] + paper[x+2][y] + paper[x+1][y-1];
	    		answer = tmp;
	    	}
    	}
    	
    	//ㅗ
    	if(x-1>=0 && y+1<M && y+2<M) {
	    	if(paper[x][y] + paper[x][y+1] + paper[x][y+2] + paper[x-1][y+1] > answer) {
	    		int tmp = paper[x][y] + paper[x][y+1] + paper[x][y+2] + paper[x-1][y+1];
	    		answer = tmp;
	    	}
    	}
    	
    	//ㅜ
    	if(x+1<N && y+1<M && y+2<M)
    	if(paper[x][y] + paper[x][y+1] + paper[x][y+2] + paper[x+1][y+1] > answer) {
    		int tmp = paper[x][y] + paper[x][y+1] + paper[x][y+2] + paper[x+1][y+1];
    		answer = tmp;
    	}
    		
    	
    }
}
