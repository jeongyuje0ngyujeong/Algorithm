import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        long[][] memo = new long[size + 1][10];

        for (int i = 1; i < 10; i++) {
            memo[1][i] = 1;
        }

        long mod = 1000000000;
        for (int i = 2; i <= size; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    memo[i][j] += memo[i - 1][1] % mod;

                } else if (j == 9) {
                    memo[i][j] += memo[i - 1][8] % mod;

                } else {
                    memo[i][j] += (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % mod;

                }
            }
        }
        long cnt = 0;
        for (int i = 0; i < 10; i++) {
            cnt += memo[size][i];
        }

        System.out.println(cnt % mod);

    }
}
