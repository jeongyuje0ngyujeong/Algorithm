import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] memo = new BigInteger[251];
        memo[0] = BigInteger.valueOf(1);
        memo[1] = BigInteger.valueOf(1);
        memo[2] = BigInteger.valueOf(3);
        BigInteger two = new BigInteger("2");
        
        for (int i = 3; i < 251; i++) {
            memo[i] = (memo[i - 1]).add(two.multiply(memo[i - 2]));
        }

        StringBuilder sb = new StringBuilder();
        String n;
        while ((n = br.readLine())!= null) {
            int width = Integer.parseInt(n);
            sb.append(memo[width]).append("\n");

        }

        System.out.println(sb);

    }
}
