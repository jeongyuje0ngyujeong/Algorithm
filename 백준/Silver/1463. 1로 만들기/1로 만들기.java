import java.io.*;

public class Main {
    private static Integer[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        memo = new Integer[num + 1];
        memo[0] = memo[1] = 0;
        System.out.println(findMin(num));
    }

    private static int findMin(int num) {

        if (memo[num] == null) {
            if (num % 6 == 0) {
                memo[num] = Math.min(Math.min(findMin(num / 2), findMin(num / 3)), findMin(num - 1)) + 1;

            } else if (num % 3 == 0) {
                memo[num] = Math.min(findMin(num / 3), findMin(num - 1)) + 1;

            } else if (num % 2 == 0) {
                memo[num] = Math.min(findMin(num / 2), findMin(num - 1)) + 1;

            } else {
                memo[num] = (findMin(num - 1)) + 1;

            }

        }

        return memo[num];
    }
}
