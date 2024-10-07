import java.io.*;
import java.util.*;

public class Main {
    public static int[][] memo;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        nums = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[size][size];
        for (int[] i : memo) {
           Arrays.fill(i, -1);
        }
        System.out.println(recur(0, size -1));
    }

    private static int recur(int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] != -1) return memo[left][right];

        if (nums[left] == nums[right])
            memo[left][right] = recur(left + 1, right - 1);
        else
            memo[left][right] = Math.min(recur(left + 1, right) + 1, recur(left, right - 1) + 1);

        return memo[left][right];
    }

}
