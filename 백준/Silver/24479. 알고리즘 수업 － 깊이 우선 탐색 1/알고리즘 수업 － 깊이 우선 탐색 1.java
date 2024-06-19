import java.io.*;
import java.util.*;

public class Main {
    private static int cnt = 1;
    private static ArrayList<Integer>[] graph;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[node + 1];
        answer = new int[node + 1];

        for (int i = 1; i < node + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }
        
        System.out.println(sb);
    }

    private static void dfs(int start) {
        if (answer[start] != 0) {
            return;
        }

        answer[start] = cnt++;
        Collections.sort(graph[start]);

        for (int i = 0; i < graph[start].size(); i++) {
            if (answer[graph[start].get(i)] == 0) {
                dfs(graph[start].get(i));
            }
        }
    }
}
