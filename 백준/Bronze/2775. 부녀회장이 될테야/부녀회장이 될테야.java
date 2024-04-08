import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] apart = new int[15][15];
        for (int i = 0; i < apart[0].length; i++) {
            apart[0][i] = i;
            for (int j = 1; j < apart.length; j++) {
                if (i != 0) apart[j][i] = apart[j - 1][i] + apart[j][i - 1];
            }
        }

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase ; i++) {
            int floor = Integer.parseInt(br.readLine());
            int roomNum = Integer.parseInt(br.readLine());
            sb.append(apart[floor][roomNum]).append("\n");

        }

        System.out.println(sb);
    }
}
