import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Character> moeumList = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
		
		while(true) {
			String word = br.readLine();
			if(word.equals("end")) break;
			
			boolean moeum = false;
			for(int i = 0; i<word.length(); i++) {
				if(moeumList.contains(word.charAt(i))) {
					moeum = true;
				}
			}
			
			boolean three = false;
			for(int i = 0; i<word.length()-2; i++) {
				char a = word.charAt(i);
				char b = word.charAt(i+1);
				char c = word.charAt(i+2);
				
				if(moeumList.contains(a)) { //모음이면
					if(moeumList.contains(b) && moeumList.contains(c)) {
						three = true;
					}
				}
				
				else if(!moeumList.contains(a)) { //자음이면
					if(!moeumList.contains(b) && !moeumList.contains(c)) {
						three = true;
					}
				}
			}
			
			boolean two = false;
			for(int i = 0; i<word.length()-1; i++) {
				char a = word.charAt(i);
				char b = word.charAt(i+1);
				
				if(a == b) {
					if(a!='e' && a!='o') {
						two = true;
					}
				}
			}
			
			
			if(moeum && !three && !two) {
				System.out.println("<"+word+"> "+ "is acceptable.");
			}
			
			else {
				System.out.println("<"+word+"> "+ "is not acceptable.");
			}
		}
		
	}

}