import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 각 군집들은 1시간마다 이동방향에 있는 다음 셀로 이동
 * 이동했는데 약품이 칠해진 셀이라면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀜
 * 살아남은 미생물 수가 0이면 군집이 사라짐
 * 이동했는데 두 개 이상 군집이 한 셀에 모이는 경우 군집이 합쳐짐
 * 미생물 수는 군집들의 미생물 수의 합이며, 이동 방향은 군집들 중 미생물 수가 가장 많은 군집의 방향
 */

public class Solution {

	//1-상, 2-하, 3-좌, 4-우
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	//미생물 객체를 만들기 위한 클래스, 갯수와 방향 저장
	static class microbe implements Comparable<microbe> {
		int x, y, count, dir;
		public microbe(int x, int y, int count, int dir) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
		}
		@Override
		public int compareTo(microbe o) { //내림차순 정렬
			return o.count-this.count;
		}
		
	}
	
	static int N,M,K;
	static List<microbe> microbes;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //한 변에 있는 셀의 개수
			M = Integer.parseInt(st.nextToken()); //격리 시간
			K = Integer.parseInt(st.nextToken()); //미생물 군집의 개수
			
			microbes = new ArrayList<>();
			for(int i = 0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				microbes.add(new microbe(x, y, n, dir)); //배열에 객체 담기
			}
			//입력 완료
			
			while(M-->0) { //격리 시간 동안
				//하나씩 꺼내서 이동
				for(int i = microbes.size()-1; i>=0; i--) {
					microbe cur = microbes.get(i);
					cur.x += dx[cur.dir];
					cur.y += dy[cur.dir];
					
					//약품에 닿으면
					if(cur.x<=0 || cur.x>=N-1 || cur.y<=0 || cur.y>=N-1) {
						cur.count /= 2; //미생물은 절반이 되고
						cur.dir = changeDir(cur.dir); //방향은 반대로 바뀐다
						
						//절반이 된 미생물이 0이 됐으면, 군집 삭제
						if(cur.count == 0) microbes.remove(i);
					}
				}
				//1시간 동안 이동 완료
				
				Collections.sort(microbes); //정렬 (미생물의 개수대로 내림차순)
				
				//이동 완료 후 같은 위치에 있는 애 탐색
				for(int i = 0; i<microbes.size()-1; i++) {
					for(int j = microbes.size()-1; j>=i+1; j--) {
						//같은 위치에 있따면
						if(microbes.get(i).x == microbes.get(j).x && microbes.get(i).y == microbes.get(j).y) {
							microbes.get(i).count += microbes.get(j).count; //미생물이 더 많은 곳으로 합치고
							microbes.remove(j); //걔는 제거해주기
						}
					}
				}
			}
			
			int sum = 0;
			for(microbe m: microbes) {
				sum += m.count;
			}
			System.out.printf("#%d %d%n", tc, sum);
		}	
	}
	
	private static int changeDir(int dir) {
		switch(dir) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return -1; //-1이 return 되는 경우는 없지만 이거 안하면 오류남
	}
}