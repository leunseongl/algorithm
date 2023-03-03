import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Dust { //미세먼지 큐에 넣기용 클래스
        int x, y, cost;
        public Dust(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    static class Cleaner { //공기청정기 좌표 저장용 클래스
        int x, y;
        public Cleaner(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    //위쪽 - 반시계방향 돌리기 (상, 우, 하, 좌)
    static int[] dx1 = {-1,0,1,0};
    static int[] dy1 = {0,1,0,-1};
    
    //아래쪽 - 시계방향 돌리기 (하, 우, 상, 좌)
    static int[] dx2 = {1,0,-1,0};
    static int[] dy2 = {0,1,0,-1};
    
    static int R, C;
    static int[][] room;
    static List<Cleaner> airCleaner = new ArrayList<>(); //공기청정기 좌표 저장
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); //행
        C = Integer.parseInt(st.nextToken()); //열
        int T = Integer.parseInt(st.nextToken()); //주어진 시간
        
        room = new int[R][C];
        for(int i = 0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1) airCleaner.add(new Cleaner(i, j));
            }
        }
        //입력 완료
                
        for(int t = 0; t<T; t++) {
            spread();
            run();
        }
        
        int sum = 0;
        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if(room[i][j] > 0) sum += room[i][j];
            }
        }
        
        System.out.println(sum);
        
    }
    
    /* 미세먼지 확산 bfs */
    private static void spread() {
        Queue<Dust> q = new ArrayDeque<>(); 
        
        //확산은 미세먼지가 있는 모든칸에서 동시에 일어남 -> 미세먼지 있는 칸 전부 넣어주기
        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if(room[i][j] > 0) {
                    q.offer(new Dust(i, j, room[i][j]));
                }
            }
        }
        
        //bfs 시작
        while(!q.isEmpty()) {
            Dust cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;
            int cnt = 0; //확산된 방향의 개수 세는 변수
            
            for(int k = 0; k<4; k++) {
                int nx = x + dx1[k];
                int ny = y + dy1[k];
                
                if(nx>=0 && nx<R && ny>=0 && ny<C) { //경계선이 아니고
                    if(room[nx][ny] != -1) { //공기청정기가 있는 곳이 아니라면
                        room[nx][ny] += cost/5; //확산
                        cnt++; //확산된 방향의 개수+1
                    }
                }
            }
            //확산 후 남은 미세먼지의 양 계산
            room[x][y] -= cost/5*cnt;
        }
        
    }
    
    private static void run() {

        //공기청정기 좌표 기준 상, 하 구분해서 돌리기
        Cleaner m1 = airCleaner.get(0); //첫 번째 공기청정기 위치
        Cleaner m2 = airCleaner.get(1); //두 번째 공기청정기 위치
        
        //위쪽 돌리기 시작점
        int x = m1.x-1; //첫 tc대로면 1
        int y = m1.y;  //첫 tc대로면 0
        int dir = 0;
        
        while(dir<4) {
            
            int nx = dx1[dir] + x;
            int ny = dy1[dir] + y;
            
            if(nx>=0 && nx<=m1.x && ny>=0 && ny<C) {
                room[x][y] = room[nx][ny];
                
                x = nx;
                y = ny;
            }
            
            else dir++;
        }
        room[m1.x][1] = 0;
        //위쪽 돌리기 완료
        
        //아래쪽 돌리기 시작점
        int x2 = m2.x+1;
        int y2 = m2.y;
        int dir2 = 0;
        
        while(dir2<4) {
        
        	int nx2 = dx2[dir2] + x2;
        	int ny2 = dy2[dir2] + y2;
        	
        	if(nx2>=m2.x && nx2<R && ny2>=0 && ny2<C) {
        		room[x2][y2] = room[nx2][ny2];
        		
        		x2 = nx2;
        		y2 = ny2;
        	}
        	
        	else dir2++;
        }
        room[m2.x][1] = 0;
        //아래쪽 돌리기 완료
        
    }

}