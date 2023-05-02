import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, left, right;
	static int[] durability; // 내구도
	static boolean[] robot; // 로봇 올리는 배열

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 칸 1~N번
		K = Integer.parseInt(st.nextToken()); // 내구도가 0인 칸의 개수가 K개 이상이면 종료

		durability = new int[2 * N];
		robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 완료

		left = 0; 
		right = N;
		int level = 0;
		
		while(K>0) {
			level++;
			rotateBelt();
			rotateRobot();
			addRobot();
		}

		System.out.println(level);
		
	}


	// 컨베이어 벨트 회전
	private static void rotateBelt() {

		left --;
		if(left < 0) {
			left = 2*N -1;
		}
		right --;
		if(right < 0) {
			right = 2*N - 1;
		}
		// 벨트가 움직임에 따라 로봇 위치 재조정 robot은 길이가 N, 0이되는 부분은 밑에서 올라와서 false, N-1도달하면 내리는 위치여서 false;
		for(int i = N-2 ; i > 0 ; i--) {
			robot[i] = robot[i-1];
		}
		robot[0] = false;
		robot[N-1] = false;

	}

	// 로봇 회전
	private static void rotateRobot() {

		// 먼저 올라간 애부터 = 뒤부터
		// 로봇은 1~N에만 위치할 수 있으므로 N-2
		for(int i = N-2 ; i >= 0 ; i--) {
			// 로봇이 있는 위치
			if(robot[i]) {
				// map배열 기준으로 left + i + 1
				// 로봇배열 기준으로 N-2
				int next = left + i + 1;
				if(next >= 2*N) next -= 2*N;
				
				if(!robot[i+1] && durability[next] >=1) {
					robot[i] = false;
					if(i+1 < N-1) robot[i+1] = true;
					
					durability[next] --;
					if(durability[next] == 0) K--;
				}
			}
		}
	}
	
	//로봇 올리기
	private static void addRobot() {

		if(durability[left] > 0) {
			robot[0] = true;
			durability[left] --;
			if(durability[left] == 0) K--;
		}
		
	}
	
}