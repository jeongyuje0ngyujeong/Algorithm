import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] S = new int[21];
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                switch (order) {
                    case "add":
                        S[num] = 1;
                        break;

                    case "remove":
                        S[num] = 0;
                        break;

                    case "check":
                        if (S[num] == 1) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;

                    case "toggle":
                        if (S[num] == 1) S[num] = 0;
                        else S[num] = 1;
                        break;

                }

            } else {
                switch (order) {
                    case "all":
                        Arrays.fill(S, 1);
                        break;

                    case "empty":
                        Arrays.fill(S, 0);
                        break;

                }

            }
        }
        System.out.println(sb);
    }

}