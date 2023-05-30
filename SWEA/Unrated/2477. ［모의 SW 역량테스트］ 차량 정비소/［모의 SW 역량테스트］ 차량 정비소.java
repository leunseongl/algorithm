import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static class Customer {
		int num, aTime, bTime, a, b;
		public Customer(int num, int aTime, int bTime, int a, int b) {
			this.num = num;
			this.aTime = aTime;
			this.bTime = bTime;
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "Customer [num=" + num + ", aTime=" + aTime + ", bTime=" + bTime + ", a=" + a + ", b=" + b + "]";
		}
	}
	
	static int N,M,K,A,B,answer;
	static int[] receipt;
	static int[] repair;
	static int[] comeTime;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //접수 창구 개수
			M = Integer.parseInt(st.nextToken()); //정비 창구 개수
			K = Integer.parseInt(st.nextToken()); //방문한 고객의 수
			A = Integer.parseInt(st.nextToken()); //타깃 접수 창구 번호
			B = Integer.parseInt(st.nextToken()); //타깃 정비 창구 번호
			
			receipt = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				receipt[i] = Integer.parseInt(st.nextToken());
			}
			
			repair = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<M; i++) {
				repair[i] = Integer.parseInt(st.nextToken());
			}
			
			comeTime = new int[K];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<K; i++) {
				comeTime[i] = Integer.parseInt(st.nextToken());
			}
			//입력 완료
			
			answer = 0;
			Queue<Customer> waitA = new ArrayDeque<>(); //접수 창구 대기
			Queue<Customer> waitB = new ArrayDeque<>(); //젱비 창구 대기
			Customer[] shopA = new Customer[N]; //접수 창구
			Customer[] shopB = new Customer[M]; //정비 창구
			List<Customer> endList = new ArrayList<>(); //끝난 고객
			
			
			while(true) {
				//모든 고객이 다 끝나면 멈춤
				if(endList.size() == K) {
					break;
				}
				
				//오는 대로 고객 번호 부여해서 접수 창구 대기열에 넣기
				for(int i = 0; i<K; i++) {
					if(comeTime[i] == 0) waitA.add(new Customer(i+1, 0, 0, 0, 0));
					comeTime[i]--;
				}
				
				//정비 창구부터
				for(int i = 0; i<M; i++) {
					if(shopB[i] == null && !waitB.isEmpty()) { //해당 정비 창구가 비어있고, 대기자가 있으면
						shopB[i] = waitB.poll();
						shopB[i].b = i+1;
					}
					//else if는 안됨
					if(shopB[i] != null) { //해당 정비 창구가 비어있지 않으면
						shopB[i].bTime++;
						if(shopB[i].bTime == repair[i]) { //수리 완료 시
							endList.add(shopB[i]); //끝난 고객에 넣어주고
							shopB[i] = null; //해당 창구 비워주기
						}
					}
				}
				
				//접수 창구
				for(int i = 0; i<N; i++) {
					if(shopA[i] == null && !waitA.isEmpty()) {
						shopA[i] = waitA.poll();
						shopA[i].a = i+1;
					}
					if(shopA[i] != null) {
						shopA[i].aTime++;
						if(shopA[i].aTime == receipt[i]) {
							waitB.add(shopA[i]);
							shopA[i] = null;
						}
					}
				}
			}
			
			int cnt = 0;
			for(int i = 0; i<endList.size(); i++) {
				Customer cur = endList.get(i);
				if(cur.a == A && cur.b == B) {
					answer += cur.num;
					cnt++;
				}
			}
			
			if(cnt == 0) answer = -1;
			System.out.printf("#%d %d%n", tc, answer);
			
		}
	}

}