import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//그냥 재귀를 돌리면 안되고, r/c가 사분면 중에서 어디 범위에 속해 있는지 체크해주고
//해당 사분면 범위에 속해 있다면 그 부분만 재귀 돌리기
public class Main {

	static int N, r, c;
	static int[][] map;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		divideConquer(0, 0, (int) Math.pow(2, N));
	}
	
	private static void divideConquer(int x, int y, int size) {

		//size: 한 변의 사이즈
		if(size == 1) {
			System.out.println(cnt);
			return;
		}
		
		int half = size/2;
		if(r<x+half && c<y+half) {
			divideConquer(x, y, half);
		}
		if(r<x+half && y+half<=c) {
			cnt += (size*size)/4;
			divideConquer(x, y+half, half);
		}
		if(x+half <=r && c<y+half) {
			cnt += ((size*size)/4)*2;
			divideConquer(x+half, y, half);
		}
		if(x+half <=r && y+half<=c) {
			cnt += ((size*size)/4)*3;
			divideConquer(x+half, y+half, half);
		}
		
	}

}