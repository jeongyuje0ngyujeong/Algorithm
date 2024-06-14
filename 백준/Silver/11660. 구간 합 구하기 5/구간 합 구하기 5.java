import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int numberOfSection = Integer.parseInt(st.nextToken());
        int[][] arrays = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            arrays[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 1; j < size; j++) {
                int input = Integer.parseInt(st.nextToken());
                arrays[i][j] += arrays[i][j - 1] + input;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfSection; i++) {
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken()) - 1;
            int column1 = Integer.parseInt(st.nextToken()) - 1;
            int row2 = Integer.parseInt(st.nextToken()) - 1;
            int column2 = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int j = row1; j <= row2; j++) {
                if (column1 > 0) {
                    sum += arrays[j][column2] - arrays[j][column1 - 1];

                } else {
                    sum += arrays[j][column2];

                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
