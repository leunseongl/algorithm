import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int K;
	static int[] picked;
	static String[] line;
	static boolean[] visit;
	static Long max = Long.MIN_VALUE;
	static Long min = Long.MAX_VALUE;
	static String realMax = "";
	static String realMin = "";
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		line = br.readLine().split(" ");
		//입력 완료
		
		picked = new int[K+1];
		visit = new boolean[10];
		permutation(0);
		
		System.out.println(realMax);
		System.out.println(realMin);
	}

	private static void permutation(int cnt) {
		
		//기저 조건
		if(cnt == K+1) {
			//System.out.println(Arrays.toString(picked));
			
			//여기서 몇 개 잘라 줄 수 있을 듯
			//현재 저장되어 있는 max와 min의 첫 글자보다 작고 크면 pass?
			
			check();
			return;
		}
		
		for(int i = 0; i<10; i++) {
			if(!visit[i]) {
				visit[i] = true;
				picked[cnt] = i;
				permutation(cnt+1);
				visit[i] = false;
			}
		}
		
	}

	//부등호를 만족하는지 체크
	private static void check() {

		for(int i = 0; i<K; i++) {
			
			if(line[i].equals(">")) {
				//부등호 만족 o
				if(picked[i] > picked[i+1]) {
					continue;
				}
				
				//부등호 만족 x
				if(picked[i] < picked[i+1]) {
					return;
				}
			}
			
			else if(line[i].equals("<")) {
				//부등호 만족 o
				if(picked[i] < picked[i+1]) {
					continue;
				}
				
				//부등호 만족 x
				if(picked[i] > picked[i+1]) {	
					return;
				}
			}
		}
		
		//리턴되지 않고 여기까지 오면 부등호를 만족하는 것
		String tmp = "";
		for(int i = 0; i<picked.length; i++) {
			tmp += picked[i];
		}
		
		//max, min 값 갱신
		if(Long.parseLong(tmp) > max) {
			max = Long.parseLong(tmp);
			realMax = tmp;
		}
		
		if(Long.parseLong(tmp) < min) {
			min = Long.parseLong(tmp);
			realMin = tmp;
		}
		
	}
	
}
