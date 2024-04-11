import java.io.*;
import java.util.*;

public class Main {
    private static int cnt = 0;
    private static int[] arr;
    private static int std;
    private static int size;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        arr = new int[size];
        std = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        if (std == 0) cnt -= 1;
        System.out.println(cnt);
    }

    private static void dfs(int sum, int curIdx) {
        if (curIdx == size) {
            if (sum == std) cnt++;
            return;
        }

        dfs(sum + arr[curIdx], curIdx + 1 );
        dfs(sum, curIdx + 1 );
    }
}

