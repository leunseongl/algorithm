import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] price;
	static List<Info> discountInfo;
	static int[] picked;
	static boolean[] isSelected;
	static int answer = Integer.MAX_VALUE;
	static class Info {
		//순서, number, discount number, 할인하는 동전 개수
		int num, dn, coin;
		public Info(int pn, int dn, int coin) {
			this.num = pn;
			this.dn = dn;
			this.coin = coin;
		}
		@Override
		public String toString() {
			return "Info [num=" + num + ", dn=" + dn + ", coin=" + coin + "]";
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		price = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		discountInfo = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			for(int j = 0; j<a; j++) {
				st = new StringTokenizer(br.readLine());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				discountInfo.add(new Info(i+1, b, c));
			}
		}
		//입력 완료
		picked = new int[N];
		isSelected = new boolean[N+1];
		permutation(0);
		
		System.out.println(answer);
	}

	//순열
	private static void permutation(int cnt) {
		
		//기저 조건
		if(cnt == N) {
			//System.out.println(Arrays.toString(picked));
			//순열 완성되면 picked를 가지고 계산 시작
			calculate(picked);
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				picked[cnt] = i; //인덱스로 
				permutation(cnt+1);
				isSelected[i] = false;
			}
		}
	}
	
	//할인, 전체 코인 개수 계산
	private static void calculate(int[] pick) {
		
		int count = 0;

		//배열 복제
		int[] priceTmp = price.clone();
		
		for(int i = 0; i<pick.length; i++) {
			
			int tmp = priceTmp[pick[i]]; //인덱스 => 실제 값
			//System.out.println(Arrays.toString(priceTmp));
			//System.out.println("tmp " + tmp);
			count += tmp;
			//System.out.println("더한 후 " + count);
			
			//할인 정보 리스트만큼 반복
			for(int j = 0; j<discountInfo.size(); j++) {
				//걔에 대한 할인 정보가 있으면
				if(discountInfo.get(j).num == pick[i]) {

					Info discount = discountInfo.get(j);
					//System.out.println("할인받을 물약 넘버 " + discount.dn);
					//System.out.println("할인 전: " + priceTmp[discount.dn]);
					if(priceTmp[discount.dn] - discount.coin > 1) {
						priceTmp[discount.dn] -= discount.coin;
					}
					else if(priceTmp[discount.dn] - discount.coin <= 1) {
						priceTmp[discount.dn] = 1;
					}
					//System.out.println("할인 후: " + priceTmp[discount.dn]);
				}
			}
		}
		//System.out.println(Arrays.toString(priceTmp));
		//System.out.println(count);
		answer = Math.min(answer, count);
	}
}
