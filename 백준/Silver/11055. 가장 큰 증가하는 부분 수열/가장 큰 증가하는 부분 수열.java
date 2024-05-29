import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        int[] memo = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = arr[i];
        }

        int max = memo[0];
        for (int i = 1; i < size; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + arr[i]);
                }
            }

            if (max < memo[i]) {
                max = memo[i];
            }
        }

        System.out.println(max);
    }
}
