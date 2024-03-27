import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Tree implements Comparable<Tree>{
		int first, plus;
		public Tree(int first, int plus) {
			this.first = first;
			this.plus = plus;
		}
		@Override
		public int compareTo(Tree o) {
			return this.plus-o.plus;
		}
		@Override
		public String toString() {
			return "first " + this.first + " plus " + this.plus;
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] ini = new int[N];
		int[] grow = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			ini[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			grow[i] = Integer.parseInt(st.nextToken());
		}
		//입력 완료
		
		Tree[] trees = new Tree[N];
		for(int i = 0; i<N; i++) {
			trees[i] = new Tree(ini[i], grow[i]);
		}
		
		Arrays.sort(trees);
		long answer = 0;
		
		for(int i = 0; i<N; i++) {
			answer += trees[i].first+(trees[i].plus*i);
		}
		
		System.out.println(answer);
	}

}