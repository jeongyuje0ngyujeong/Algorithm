import java.io.*;
import java.util.*;

public class Main {
    private static int count = 0;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            map = new int[h][w];
            isVisited = new boolean[h][w];
            boolean checkIsland = false;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int isIsland = Integer.parseInt(st.nextToken());
                    map[i][j] = isIsland;
                }
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 1 && !isVisited[i][j]) {
                        checkIsland = true;
                        count++;
                        bfs(i, j);
                    }
                }
            }

            if (!checkIsland) sb.append(0).append("\n");
            else sb.append(count).append("\n");
            count = 0;
        }
        System.out.println(sb);
    }

    private static void bfs(int y, int x) {
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()){
            int[] current = queue.poll();
            isVisited[current[0]][current[1]] = true;
            for (int i = 0; i < 8; i++) {
                int moveX = current[1] + dx[i];
                int moveY = current[0] + dy[i];
                if (moveX >= map[0].length || moveX < 0 || moveY >= map.length || moveY < 0) continue;
                if (map[moveY][moveX] == 1 && !isVisited[moveY][moveX]) {
                    isVisited[moveY][moveX] = true;
                    queue.add(new int[]{moveY, moveX});
                }
            }
        }
    }
}
