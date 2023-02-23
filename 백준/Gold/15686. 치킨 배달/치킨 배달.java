import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int x; //행
		int y; //열
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
	static int M;
	static int[][] city;
	static List<Node> chicken = new ArrayList<>(); //치킨집 좌표
	static List<Node> home = new ArrayList<>(); //집 좌표
	static int chickenN; //치킨집 개수
	static int homeN; //집 개수
	static int[] picked;
	static int cityChickenDist = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//치킨집 좌표, 집 좌표 저장
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(city[i][j] == 2)  {
					chicken.add(new Node(i, j));
				}
				
				if(city[i][j] == 1) {
					home.add(new Node(i, j));
				}
			}
		}
		
		chickenN = chicken.size();
		homeN =	home.size();
		picked = new int[M];
		//치킨집 조합 구하기
		combination(0, 0);
		System.out.println(cityChickenDist);
	}
	
	//조합은 index 번호로만
	private static void combination(int cnt, int start) {
		
		if(cnt == M) {
			cityChickenDist = Math.min(cityChickenDist, chickDist());
			return;
		}
		
		for(int i = start; i<chickenN; i++) {
			picked[cnt] = i;
			combination(cnt+1, i+1);
		}

	}
	
	private static int chickDist() {
		
		int tot = 0;
		//치킨거리: 치킨집-집 중 가장 작은 것
		for(int i = 0; i<homeN; i++) {
			int hx = home.get(i).x;
			int hy = home.get(i).y;
			int disTmp = Integer.MAX_VALUE;
			for(int j = 0; j<picked.length; j++) { 
				int cx = chicken.get(picked[j]).x;
				int cy = chicken.get(picked[j]).y;
				disTmp = Math.min(disTmp, Math.abs(cx-hx)+Math.abs(cy-hy));
			}

			tot += disTmp;
			
		}
		
		return tot;
				
	}

}
