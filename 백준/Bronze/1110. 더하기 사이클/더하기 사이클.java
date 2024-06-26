import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int cnt = 0;
        int checkNum = num;

        while (true) {
            cnt++;

            if (checkNum < 10) {
                String numStr = String.valueOf(checkNum) + checkNum;
                checkNum = Integer.parseInt(numStr);

            } else {
                int leftNum = checkNum / 10;
                int rightNum = checkNum % 10;
                int sum = leftNum + rightNum;
                int sumRight = sum % 10;
                checkNum = Integer.parseInt(String.valueOf(rightNum) + sumRight);
            }

            if (checkNum == num) {
                break;
            }
        }

        System.out.println(cnt);
    }
}