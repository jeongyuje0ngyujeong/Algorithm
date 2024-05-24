import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int sum = arr[0];
        for (int i = 0; i < size - 1;) {
            sum += arr[i + 1];
            if (sum < arr[i + 1]) {
                sum = arr[i + 1];
            }

            if (sum > max) {
                max = sum;
            }
            i++;
        }

        System.out.println(max);
    }
}
