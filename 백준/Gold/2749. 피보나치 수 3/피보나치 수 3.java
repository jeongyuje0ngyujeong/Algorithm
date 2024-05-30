import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long period = 1500000;
        long m = 1000000;
        Long[] memo = new Long[(int) period + 1];
        memo[0] = (long) 0;
        memo[1] = (long) 1;
        for (int i = 2; i < period; i++) {
            memo[i] = ((memo[i - 1] % m) + (memo[i - 2] % m)) % m;
        }

        System.out.println(memo[(int)(n % period)]);
    }
}
