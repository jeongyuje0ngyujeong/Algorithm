import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] isVisited;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        isVisited = new boolean[size][size];
        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!isVisited[i][j]) {
                    isVisited[i][j] = true;
                    Bfs(i, j);
                    count++;
                }
            }
        }
        int nonColorBlind = count;


        count = 0;
        isVisited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!isVisited[i][j]) {
                    isVisited[i][j] = true;
                    Bfs(i, j);
                    count++;
                }
            }
        }
        int colorBlind = count;

        System.out.println(nonColorBlind);
        System.out.println(colorBlind);
    }

    private static void Bfs(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        char checkColor = map[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = current[0] + dx[i];
                int moveY = current[1] + dy[i];

                if (moveX >= map.length || moveX < 0 || moveY >= map.length || moveY < 0) {
                    continue;
                }

                if (map[moveX][moveY] == checkColor && !isVisited[moveX][moveY]) {
                    isVisited[moveX][moveY] = true;
                    queue.add(new int[]{moveX, moveY});
                }
            }
        }
    }

}