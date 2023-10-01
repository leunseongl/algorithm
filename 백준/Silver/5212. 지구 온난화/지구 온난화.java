import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

		static int[] dx = {-1,0,1,0};
		static int[] dy = {0,1,0,-1};
		
		public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[R][C];
			for(int i = 0; i<R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			//입력 완료
			
			List<int[]> save = new ArrayList<>(); //바다로 만들 값 저장
			int minR = 10, minC = 10;
	        int maxR = 0, maxC = 0;
			
	        for(int i = 0 ; i < map.length ; i++) {
	            for(int j = 0 ; j < map[i].length ; j++) {
	              if(map[i][j] == 'X') {
	                
	                int count = 0;
	                
	                for(int k = 0 ; k < dx.length ; k++) {
	                  int nx = i + dx[k];
	                  int ny = j + dy[k];
	                  
	                  if((nx>=0 && nx < R && ny >=0 && ny < C )){
	                    if(map[nx][ny] == 'X') {
	                      continue;
	                    }
	                  }
	                  count++;
	                }
	                
	                if(count>=3) { //잠기는 경우
						int[] tmp = new int[2];
						tmp[0] = i;
						tmp[1] = j;
						
						save.add(tmp);
					}
	              }
	            }
	        }
			
			for(int[] t: save) {
				map[t[0]][t[1]] = '.';
			}
			//물에 잠길 곳 처리
			
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j] == 'X') {
						minR = Math.min(minR, i); // 지도 출력 범위 갱신
	                    minC = Math.min(minC, j);
	                    maxR = Math.max(maxR, i);
	                    maxC = Math.max(maxC, j);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = minR; i<=maxR; i++) {
				for(int j = minC; j<=maxC; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
		}

}