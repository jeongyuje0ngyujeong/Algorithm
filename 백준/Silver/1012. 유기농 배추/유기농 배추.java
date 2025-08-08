import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase != 0) {
            testCase--;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int cabNum = Integer.parseInt(st.nextToken());

            int[][] map = new int[row][col];
            for (int i = 0; i < cabNum; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            Queue<int[]> queue;
            int wormNum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1) {
                        queue = new LinkedList<>();
                        queue.add(new int[] {i, j});
                        map[i][j]--;
                        int[] dx = {0, 0, -1, 1};
                        int[] dy = {-1, 1, 0, 0};
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int moveX = cur[1] + dx[k];
                                int moveY = cur[0] + dy[k];
                                if (col <= moveX || moveX < 0 || row <= moveY || moveY < 0 || map[moveY][moveX] != 1) {
                                    continue;
                                }
                                queue.add(new int[] {moveY, moveX});
                                map[moveY][moveX]--;
                            }
                        }
                        wormNum++;
                    }
                }
            }
            System.out.println(wormNum);
        }
    }
}
