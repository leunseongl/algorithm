import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static class Info implements Comparable<Info> {
		private String name;
		private int power;
		
		public Info(String name, int power) {
			this.name = name;
			this.power = power;
		}

		@Override
		public int compareTo(Info o) {
			return this.power-o.power; //오름차순 정렬
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); //칭호의 개수
		int M = Integer.parseInt(st.nextToken()); //캐릭터들의 개수
		
		Info[] infos = new Info[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			infos[i] = new Info(n, p);
		}
		
		Arrays.sort(infos); //정렬
		
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(br.readLine());
			int start = 0;
			int end = N-1;
			
			while(start<=end) {
				int mid = (start+end)/2;
				
				if(num > infos[mid].power) {
					start = mid+1;
				}
				
				else {
					end = mid-1;
				}
			}
			sb.append(infos[start].name).append("\n");
		}
		System.out.println(sb);
	}

}