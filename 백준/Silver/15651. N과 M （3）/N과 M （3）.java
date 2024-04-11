import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int size;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        arr = new int[size];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int idx) {
        if (idx == size) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[idx] = i;
            dfs(idx + 1);
        }
    }
}
