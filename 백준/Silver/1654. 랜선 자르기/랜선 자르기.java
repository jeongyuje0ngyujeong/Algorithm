import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] kArr = new long[k];
        long max = -1;
        for (int i = 0; i < k; i++) {
            kArr[i] = Integer.parseInt(br.readLine());

            if (kArr[i] > max) {
                max = kArr[i];
            }
        }

        max++;
        long min = 1;
        while (min < max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int i = 0; i < k; i++) {
                cnt += kArr[i] / mid;

                if (cnt >= n) break;
            }

            if (cnt >= n) {
                min = mid + 1;

            } else {
                max = mid;

            }
        }

        System.out.println(min - 1);
    }
}
