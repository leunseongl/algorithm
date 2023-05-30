import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());
			int A = Integer.parseInt(st1.nextToken());
			int B = Integer.parseInt(st1.nextToken());
			
			int[] shopA = new int[N+1];
			int[] shopB = new int[M+1];
			int[] customer = new int[K+1];
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 1; i < N+1; i++) {
				shopA[i] = Integer.parseInt(st2.nextToken());
			}
			
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int i = 1; i < M+1; i++) {
				shopB[i] = Integer.parseInt(st3.nextToken());
			}
			
			StringTokenizer st4 = new StringTokenizer(br.readLine());
			for(int i = 1; i < K+1; i++) {
				customer[i] = Integer.parseInt(st4.nextToken());
			}
			
			
			Queue<Customer> waitA = new LinkedList<>(); //a 대기
			Queue<Customer> waitB = new LinkedList<>(); //b 대기
			Customer[] chkA = new Customer[N+1]; //a 창구
			Customer[] chkB = new Customer[M+1]; //b 창구
			List<Customer> end = new ArrayList<>(); //완료 고객
			
			int cnt = 0;
			int arrived = 0;
			
			while(true) {
				if(cnt == K) {
					break;
				}
				

				for(int i = 1; i < K+1; i++) {
					if(customer[i] == 0) {
						waitA.add(new Customer(0, 0, i, 0, 0));
						arrived++;
					}
					customer[i]--;
				}
				//도착 하는대로 고객 번호 부여하고, a대기열로
				
				
				for(int i = 1; i < M+1; i++) {
					if(chkB[i] == null && !waitB.isEmpty()) {
						chkB[i] = waitB.poll();
						chkB[i].b = i;
					}
					if(chkB[i] != null) {
						chkB[i].b_time++;
						if(chkB[i].b_time == shopB[i]) {
							end.add(chkB[i]);
							chkB[i] = null;
							cnt++;
						}
					}
				}
				
				for(int i = 1; i < N+1; i++) {
					if(chkA[i] == null && !waitA.isEmpty()) {
						chkA[i] = waitA.poll();
						chkA[i].a = i;
					}
					if(chkA[i] != null) {
						chkA[i].a_time++;
						if(chkA[i].a_time == shopA[i]) {
							waitB.add(chkA[i]);
							chkA[i] = null;
						}
					}
				}
				
				
			}
			
			int ans = 0;
			for(int i = 0; i < end.size(); i++) {
				if(end.get(i).a == A && end.get(i).b == B) {
					ans += end.get(i).c_num;
				}
			}
			if(ans == 0) {
				ans = -1;
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
	}
	static class Customer{
		int a_time;
		int b_time;
		int c_num;
		int a;
		int b;
		
		public Customer(int a_time, int b_time, int c_num, int a, int b) {
			this.a_time = a_time;
			this.b_time = b_time;
			this.c_num = c_num;
			this.a = a;
			this.b = b;
		}
	}
}