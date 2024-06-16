import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        long std = Integer.parseInt(st.nextToken());
        long[] woods = new long[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            woods[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(woods);

        long start = 0;
        long end = woods[size - 1] - 1;
        long point = (start + end) / 2;
        long check = 0;

        while (start <= end) {
            check = 0;
            for (int i = 0; i < size; i++) {
                if (point >= woods[i]) {
                    continue;
                }
                check += (woods[i] - point);

            }
            if (check > std) {
                start = point + 1;
                point = (start + end) / 2;

            } else if (check < std) {
                end = point - 1;
                point = (start + end) / 2;

            } else {
                break;

            }
        }

        System.out.println(point);
    }
}
