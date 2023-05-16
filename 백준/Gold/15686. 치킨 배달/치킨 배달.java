import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//0은 빈칸, 1은 집, 2는 치킨집
public class Main {

	static class Area {
		int x,y;
		public Area(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M;
	static int[][] city;
	static List<Area> home;
	static List<Area> chickenshop;
	static int[] picked;
	static int res;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
			city[i][j] = Integer.parseInt(st.nextToken());	
			}
		} 

		//치킨집, 집 좌표 저장
		home = new ArrayList<>();
		chickenshop = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(city[i][j] == 1) home.add(new Area(i, j));
				if(city[i][j] == 2) chickenshop.add(new Area(i, j));
			}
		}
		
		picked = new int[M];
		res = Integer.MAX_VALUE;
		combination(0, 0);
		
		System.out.println(res);
	}

	private static void combination(int cnt, int start) {
		
		if(cnt == M) { 
			res = Math.min(distance(picked), res);
			return;
		}
		for(int i = start; i<chickenshop.size(); i++) {
			picked[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
 	
	//뽑힌 조합을 인자로
	private static int distance(int[] arr) {
		//집을 기준으로 집과 가장 가까운 치킨집 사이의 거리 => 치킨 거리
		//모든 집의 치킨거리 합 => 도시의 치킨 거리
		//이 함수는 도시의 치킨 거리를 리턴하는 함수
		//리턴해서 위에서 가장 작은 도시의 치킨거리를 구해야 함
		
		int cityDistance = 0;
		for(int i = 0; i<home.size(); i++) {
			int chickenDist = Integer.MAX_VALUE;
			for(int j = 0; j<arr.length; j++) {
				int r = Math.abs(home.get(i).x - chickenshop.get(arr[j]).x);
				int c = Math.abs(home.get(i).y - chickenshop.get(arr[j]).y);
				if(r+c<chickenDist) chickenDist = r+c;
			}
			cityDistance += chickenDist;
		}
		 return cityDistance;
	}
}
