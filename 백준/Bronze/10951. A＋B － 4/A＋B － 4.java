import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            String line = br.readLine();
            if(line == null) break;
            st = new StringTokenizer(line," ");
            int A = Integer.parseInt(st.nextToken());
//            System.out.println(A);
            int B = Integer.parseInt(st.nextToken());
//            System.out.println(B);
            System.out.println(A+B);
        }
    }
}