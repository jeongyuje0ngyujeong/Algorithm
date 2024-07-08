import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int cities = 0;
    private static boolean[] isVisited;
    private static int[][] costs;
    private static int finalCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cities = Integer.parseInt(br.readLine());
        isVisited = new boolean[cities];
        costs = new int[cities][cities];

        for (int i = 0; i < cities; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cities; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < cities; i++) {
            isVisited[i] = true;
            route(i, i, 1, 0);
            isVisited[i] = false;
        }

        System.out.println(finalCost);
    }

    private static void route(int first, int current, int depth, int checkCost) {
        if (depth == cities && costs[current][first] > 0) {
            finalCost = Math.min(checkCost + costs[current][first], finalCost);
            return;
        }

        for (int i = 0; i < cities; i++) {
            if (!isVisited[i] && costs[current][i] > 0) {
                isVisited[i] = true;
                route(first, i, depth + 1, checkCost + costs[current][i]);
                isVisited[i] = false;
            }
        }
    }
}
