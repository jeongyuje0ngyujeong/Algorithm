import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] ropes = new int[num];

        for (int i = 0; i < num; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        int max = ropes[0] * num;
        int k = 0;
        for (int i = num - 1; i >= 0; i--) {
            k++;
            if (max < ropes[i] * k) {
                max = ropes[i] * k;
            }
        }

        System.out.println(max);
    }
}
