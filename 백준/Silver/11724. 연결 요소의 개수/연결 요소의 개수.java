import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    
    static boolean[] isVisited;
    static ArrayList<Integer>[] nodeData;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodesNum = Integer.parseInt(st.nextToken());
        int edgesNum = Integer.parseInt(st.nextToken());
        isVisited = new boolean[nodesNum + 1];
        nodeData = new ArrayList[nodesNum + 1];

        for (int i = 1; i < nodesNum + 1; i++) {
            nodeData[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgesNum; i++) {
            st = new StringTokenizer(br.readLine());
            int startP = Integer.parseInt(st.nextToken());
            int endP = Integer.parseInt(st.nextToken());

            nodeData[startP].add(endP);
            nodeData[endP].add(startP);
        }

        int count = 0;
        isVisited[0] = true;

        for (int i = 1; i < nodesNum + 1; i++) {
            if ( ! isVisited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);

    }

    private static void DFS(int nodeNum) {
        if (isVisited[nodeNum]) {
            return;
        }
        isVisited[nodeNum] = true;
        for (int num : nodeData[nodeNum]) {
            if (!isVisited[num]) {
                DFS(num);
            }
        }
    }
}
