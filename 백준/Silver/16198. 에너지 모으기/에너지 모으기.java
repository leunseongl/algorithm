import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<Integer> marbles;
	static int[] picked; //순열용
	static boolean[] visit; //순열용
	static int best;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		marbles = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			marbles.add(Integer.parseInt(st.nextToken()));
		}
		
		picked = new int[N-2];
		visit = new boolean[N];
		
		//첫 번째 구슬과 마지막 구슬은 방문 처리를 해둔 상태로 순열 돌리기
		visit[0] = true;
		visit[N-1] = true;
		permutation(0);
		System.out.println(best);
	}
	
	private static void permutation(int cnt) {
		
		//기저 조건, 전체 구슬에서 앞, 뒤 구슬 개수를 제외한 N-2
		if(cnt == N-2) {
			makeEnergy(picked);
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if(!visit[i]) {
				visit[i]= true;
				picked[cnt] = i;
				permutation(cnt+1);
				visit[i] = false;
			}
		}
	}
	
	private static void makeEnergy(int[] picked) {
	
		//리스트 복사
		List<Integer> tmpList = new ArrayList<>(marbles);
		
		int energy = 0;
		
		for(int i = 0; i<picked.length; i++) {
			
			//1. 에너지 구슬 하나를 고른다 -> picked[i]
			int tmp = tmpList.get(picked[i]);
			
			//2. 에너지 모으기
			int a = tmpList.get(picked[i]-1);
			int b = tmpList.get(picked[i]+1);
			energy += a*b;
			
			//3. 고른 에너지 구슬을 제거한다
			tmpList.remove(picked[i]);
			
			for(int j = i+1; j<picked.length; j++) {
				if(picked[i] < picked[j]) {
					picked[j]--;
				}
			}
			
		}
		best = Math.max(energy, best);
	}
}
