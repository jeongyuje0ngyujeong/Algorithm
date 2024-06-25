import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine());
        int price = 0;

        for (int i = 0; i < testCase; i++) {
            price = Integer.parseInt(br.readLine());
            int options = Integer.parseInt(br.readLine());

            for (int j = 0; j < options; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int option = Integer.parseInt(st.nextToken());
                int optPrice = Integer.parseInt(st.nextToken());

                price += (option * optPrice);
            }
            sb.append(price).append("\n");
        }

        System.out.println(sb);
    }
}
