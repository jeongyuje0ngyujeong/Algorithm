import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stdNum = Integer.parseInt(br.readLine());
        int[][] stdArr = new int[stdNum][2];

        for (int i = 0; i < stdNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stdArr[i][0] = Integer.parseInt(st.nextToken());
            stdArr[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stdNum; i++) {
            int cnt = 1;
            for (int j = 0; j < stdNum; j++) {
                if (i == j) continue;
                if (stdArr[i][0] < stdArr[j][0] && stdArr[i][1] < stdArr[j][1]) cnt++;
            }
            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}
