import java.io.*;
import java.util.*;

public class Main {
    private static int[] nums;
    private static int[] check;
    private static boolean[] isVisited;
    private static int m;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        m = Integer.parseInt(str.split(" ")[1]);
        nums = new int[n];
        check = new int[m];
        isVisited = new boolean[n];

        str = br.readLine();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str.split(" ")[i]);
        }

        Arrays.sort(nums);
        dfs(0);
        System.out.println(sb);

    }

    private static void dfs (int depth) {
        if (depth == m) {
            for (int i : check) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                check[depth] = nums[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
