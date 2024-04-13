import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] map = new int[num][2];
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            map[i][0] = Integer.parseInt(str.split(" ")[0]);
            map[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(map, ((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
