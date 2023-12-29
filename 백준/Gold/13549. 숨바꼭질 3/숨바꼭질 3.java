import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] dist; //dist배열의 인덱스가 위치, 해당 배열에 저장되는 값이 시간 (몇 초인지)
	
	static class Data {
		int position, time;
		public Data(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dijkstra(N);
		System.out.println(dist[K]);
		
	}
	
	private static void dijkstra(int start) {
		
		dist = new int[100001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		pq.offer(new Data(start, 0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll(); //위치
			//System.out.println(cur);
			
			if(cur.position == K) return;
			
			//if(dist[cur] < cur) continue;
			
			if(cur.position*2<100001 && dist[cur.position*2] > cur.time) {
				dist[cur.position*2] = cur.time;
				pq.offer(new Data(cur.position*2, dist[cur.position*2]));
			}
			
			if(cur.position-1>=0 && dist[cur.position-1] > cur.time+1) {
				dist[cur.position-1] = cur.time+1;
				pq.offer(new Data(cur.position-1, dist[cur.position-1]));
			}
			
			if(cur.position+1<100001 && dist[cur.position+1] > cur.time+1) {
				dist[cur.position+1] = cur.time+1;
				pq.offer(new Data(cur.position+1, dist[cur.position+1]));
			}
			
		}
		
	}

}