import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.security.auth.Subject;

public class Main {

	public static void main(String[] args) throws Exception {

		Map<String, Double> map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double totalScore = 0;
		double subjectScore = 0;
		for(int i = 0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if(!grade.equals("P")) {
				double tmp = map.get(grade);
				totalScore += score*tmp;
				subjectScore += score;
			}
		}
		
		//System.out.println(totalScore + " " + subjectScore);
		System.out.println(totalScore/subjectScore);
		
		
	}

}