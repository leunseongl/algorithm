import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int hansu = 0;
		for(int i = 1; i<=N; i++) {
			if(i<100) hansu++;
			else {
				String tmp = Integer.toString(i);
				int[] digit = new int[tmp.length()];
				for(int j = 0; j<tmp.length(); j++) {
					digit[j] = tmp.charAt(j)-'0';
				}
				
				if(digit[0] - digit[1] == digit[1] - digit[2]) hansu++;
			}
		}
		System.out.println(hansu);
	}

}
