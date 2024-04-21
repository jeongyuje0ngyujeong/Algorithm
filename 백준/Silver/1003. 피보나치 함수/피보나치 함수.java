import java.io.*;

public class Main {
    private static Integer[][] memo = new Integer[41][2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for (int i = 0; i < testNum; i++) {
            int n = Integer.parseInt(br.readLine());
            fibo(n);
            sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
        }
        System.out.println(sb);
    }

    private static Integer[] fibo(int n) {
        for (int i = 2; i <= n; i++) {
            memo[i][0] = memo[i - 1][0] + memo[i - 2][0];
            memo[i][1] = memo[i - 1][1] + memo[i - 2][1];
        }
        return memo[n];
    }
}
