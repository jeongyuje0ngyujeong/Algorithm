import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] isVisited;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] cabbageArea = new int[testCase];
        for (int i = 0; i < testCase; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int mapX = Integer.parseInt(st.nextToken());
            int mapY = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            map = new int[mapY][mapX];
            isVisited = new boolean[mapY][mapX];

            for (int idx = 0; idx < point; idx++) {
                st = new StringTokenizer(br.readLine());
                int pointX = Integer.parseInt(st.nextToken());
                int pointY = Integer.parseInt(st.nextToken());

                map[pointY][pointX] = 1;
            }

            for (int y = 0; y < mapY; y++) {
                for (int x = 0; x < mapX; x++) {
                    if (map[y][x] == 1 && !isVisited[y][x]) {
                        isVisited[y][x] = true;
                        Bfs(x, y);
                        cabbageArea[i]++;
                    }
                }
            }

        }

        for (int answer : cabbageArea) {
            System.out.println(answer);
        }
    }

    private static void Bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = dx[i] + current[1];
                int moveY = dy[i] + current[0];
                int mapColumn = map[0].length;
                int mapRow = map.length;

                if (moveX >= mapColumn || moveX < 0 || moveY >= mapRow || moveY < 0) {
                    continue;
                }

                if (map[moveY][moveX] == 1 && ! isVisited[moveY][moveX]){
                    isVisited[moveY][moveX] = true;
                    queue.add(new int[] {moveY, moveX});
                }
            }
        }
    }
}
