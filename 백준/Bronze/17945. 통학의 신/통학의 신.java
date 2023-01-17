import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int x = -a + (int)Math.sqrt(a*a-b);
		int y = -a - (int)Math.sqrt(a*a-b);
		
		if(x>y) System.out.println(y + " " + x);
		else if(x == y) System.out.println(x);
		else System.out.println(x + " " + y);
	}

}