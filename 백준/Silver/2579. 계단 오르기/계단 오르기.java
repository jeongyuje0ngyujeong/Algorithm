import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int [size + 1];
        int[] memo = new int [size + 1];

        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (size <= 2) {
           memo[size] = arr[size] + arr[size - 1];
           System.out.println(memo[size]);
           return;
        }
        
        memo[1] = arr[1];
        memo[2] = arr[1] + arr[2];
        for (int i = 3; i <= size; i++) {
            memo[i] = Math.max(memo[i - 3] + arr[i - 1], memo[i - 2]) + arr[i];
        }
        
        System.out.println(memo[size]);
    }
}
