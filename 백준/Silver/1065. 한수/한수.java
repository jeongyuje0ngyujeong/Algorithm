import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        boolean[] memo = new boolean[1001];
        for (int i = 0; i < 100; i++) {
            memo[i] = true;
        }

        if (num >= 100) {
            for (int i = 100; i <= num ; i++) {
                String strNum = String.valueOf(i);
                int strNumLen = strNum.length();
                int[] arr = new int[strNumLen];

                for (int j = 0; j < strNumLen; j++) {
                    arr[j] = (strNum.charAt(j) - '0');
                }

                int d = arr[1] - arr[0];
                boolean isTrue = false;
                for (int j = 2; j < strNumLen; j++) {
                    if (arr[j] - arr[j - 1] != d) {
                        isTrue = false;
                        break;
                    } else isTrue = true;
                }

                if (isTrue) memo[i] = true;
            }
        }
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (memo[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
