import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Data {
		int left, right, cnt, make;
		public Data(int left, int right, int cnt, int make) {
			this.left = left;
			this.right = right;
			this.cnt = cnt; //횟수
			this.make = make;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //짜장면의 수
		int M = Integer.parseInt(st.nextToken()); //웍의 수
		
		int[] woks = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			woks[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		int[] dist = new int[10002];
		boolean[] visit = new boolean[10002];
		
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(0,0,0,0));
		//q.offer(new Data(woks[0], woks[1], 1, woks[0]+woks[1]));
		
		//dist[woks[0]+woks[1]] = 1;
		//visit[woks[0]+woks[1]] = true;
		
		//bfs 시작
		while(!q.isEmpty()) {
			Data cur = q.poll();
			//System.out.println("left " + cur.left + " right " + cur.right + " cnt " + cur.cnt + " make " + cur.make);
			//주문 받은 짜장면 완성
			if(cur.make == N) {
				break;
			}
			
			for(int i = 0; i<M+1; i++) {
				for(int j = 0; j<M+1; j++) {
					if(i==j) continue;
					//if(cur.make+woks[i]+woks[j]>=10001) continue;
					
					if(cur.make+woks[i]+woks[j]<=10001 && !visit[cur.make+woks[i]+woks[j]]) {
						q.offer(new Data(woks[i], woks[j], cur.cnt+1, cur.make+woks[i]+woks[j]));
						visit[cur.make+woks[i]+woks[j]] = true;
						dist[cur.make+woks[i]+woks[j]] = cur.cnt+1;
					}
				}
			}
		}
		
		if(dist[N] == 0) System.out.println(-1);
		else System.out.println(dist[N]);
		//System.out.println(Arrays.toString(dist));
		
	}
	
	

}