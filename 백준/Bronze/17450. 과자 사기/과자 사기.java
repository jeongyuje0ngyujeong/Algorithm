import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 3;
        double goodPrice = Double.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            double check = 0;

            if (price * 10 < 5000) {
                check = (double) (weight * 10) / (price * 10);

            } else {
                check = (double) (weight * 10) / ((price * 10) - 500);

            }

            if (check > goodPrice) {
                goodPrice = check;
                answer = i;
            }
        }

        char[] snacks = {'S', 'N', 'U'};
        System.out.println(snacks[answer]);
    }
}
