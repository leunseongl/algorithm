import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//회전시키기 전에 같이 돌아야 하는 자석 미리 판단 후 돌리기
public class Solution {
	
	static int[][] magnet;
	static int[] dirStore;
	static int[] score = {1,2,4,8};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			magnet = new int[4][8]; //입력 자석 값
			int K = Integer.parseInt(br.readLine());
			
			//자석 입력
			for(int i = 0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//K개의 회전 정보 입력
			for(int i = 0; i<K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				
				dirStore = new int[4]; //자석 별 회전 방향 저장	
				//0 - 회전 x / 1 - 시계 방향 회전 / -1 - 반시계 방향 회전
				dirStore[num] = dir;
				
				
				//오른쪽 검사 (회전할 자석 num을 기준으로 오른쪽 전부)
				for(int j = num+1; j<4; j++) {
					if(magnet[j-1][2] == magnet[j][6]) break; 
					//같으면 break
					else dirStore[j] = dirStore[j-1] == 1 ? -1:1; 
					//다르면반대로 회전방향 기록
				}
				
				
				//왼쪽 검사 (회전할 자석 num을 기준으로 왼쪽 전부)
				for(int j = num-1; j>=0; j--) { 
					if(magnet[j+1][6] == magnet[j][2]) break; 
					//같으면 break
					else dirStore[j] = dirStore[j+1] == 1 ? -1:1; 
					//다르면반대로 회전방향 기록
				}
				
				//회전
				rotate();
			}
			
			int answer = 0;
			for(int i = 0; i<4; i++) {
				if(magnet[i][0] == 1) {
					answer += score[i];
				}
			}
			
			System.out.printf("#%d %d%n", tc, answer);
			
		}
		
	}
	
	private static void rotate() {

		for(int i = 0; i<4; i++) {
			if(dirStore[i] == 0) continue;
			
			else if(dirStore[i] == 1) {
				int tmp1 = magnet[i][7];
				for(int j = 6; j>=0; j--) {
					magnet[i][j+1] = magnet[i][j];
				}
				magnet[i][0] = tmp1;
			}
			
			else {
				int tmp2 = magnet[i][0];
				for(int j = 0; j<7; j++) {
					magnet[i][j] = magnet[i][j+1];
				}
				magnet[i][7] = tmp2;
			}
		}
		
	}
	
}