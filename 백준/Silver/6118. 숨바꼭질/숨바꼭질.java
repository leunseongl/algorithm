import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//1번 헛간에서 최소 거리가 가장 먼 헛간을 찾는 문제
//만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다
//문제가 요구하는 출력을 하려면 모든 탐색을 해야한다
public class Main {

	static int N, M;
	static List<List<Integer>> list;
	static int[] dist;
	static boolean[] visit;
	
	static class Data {
		int num, cnt;
		public Data(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //헛간 개수
		M = Integer.parseInt(st.nextToken()); //길 개수
		
		list = new ArrayList<>();
		for(int i = 0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		//입력 완료
		
		dist = new int[N+1];
		bfs();
		
		//System.out.println(Arrays.toString(dist));
		
		int big = 0;
		for(int i = 0; i<=N; i++) {
			if(dist[i]>big) {
				big = dist[i];
			}
		}
		
		int idx = 0;
		int bigCnt = 0;
		for(int i = N; i>=0; i--) {
			if(dist[i] == big) {
				idx = i;
				bigCnt++;
			}
		}
		
		System.out.println(idx + " " + big + " " + bigCnt);
	}

	private static void bfs() {
		visit = new boolean[N+1];
		visit[1] = true;
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(1, 0));
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for(int o : list.get(cur.num)) {
				if(!visit[o]) {
					visit[o] = true;
					dist[o] = cur.cnt+1;
					q.offer(new Data(o, cur.cnt+1));
				}
			}
		}
	}
}