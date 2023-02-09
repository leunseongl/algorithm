import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int S, P;
	static String DNA;
	static int[] ACGT;
	//static int[] check;
	static int res = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		DNA = br.readLine();
		st = new StringTokenizer(br.readLine());

		ACGT = new int[4];
		for(int i = 0; i<4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}

		//맨 처음 P개의 숫자 탐색
		for(int i = 0; i<P; i++) {
			char tmp = DNA.charAt(i);
			if(tmp == 'A') ACGT[0] -=1;
			if(tmp == 'C') ACGT[1] -=1;
			if(tmp == 'G') ACGT[2] -=1;
			if(tmp == 'T') ACGT[3] -=1;
			//System.out.println(tmp);
		}
		
		//첫 탐색 후 체크 -> true면 비번
		boolean flag = true;
		for(int i = 0; i<4; i++) {
			if(ACGT[i] > 0) flag = false;
		}
		//System.out.println(Arrays.toString(ACGT));
		
		if(flag == true) res++;

		//이후 탐색
		for(int i = P; i<DNA.length(); i++) {
			char insert = DNA.charAt(i);
			char pop = DNA.charAt(i-P);
			if(insert == 'A') ACGT[0] -=1;
			if(insert == 'C') ACGT[1] -=1;
			if(insert == 'G') ACGT[2] -=1;
			if(insert == 'T') ACGT[3] -=1;
			
			if(pop == 'A') ACGT[0] +=1;
			if(pop == 'C') ACGT[1] +=1;
			if(pop == 'G') ACGT[2] +=1;
			if(pop == 'T') ACGT[3] +=1;
			
			
			//System.out.println(Arrays.toString(ACGT));
			flag = true;
			for(int j = 0; j<4; j++) {
				if(ACGT[j] > 0) flag = false;
			}
			
			if(flag == true) res++;
			
		}
		
		System.out.println(res);
	}

}
