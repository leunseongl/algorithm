import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //메모장에 적은 키워드 개수
		int M = Integer.parseInt(st.nextToken()); //블로그에 쓴 글의 개수
		
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i<N; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i<M; i++) {
			String[] tmp = br.readLine().split(",");
			for(int j = 0; j<tmp.length; j++) {
				if(set.contains(tmp[j])) {
					set.remove(tmp[j]);
				}
			}
			System.out.println(set.size());
		}
		
	}

}