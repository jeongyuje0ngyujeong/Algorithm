import java.io.*;
import java.util.*;

public class Main {
    private static int subin;
    private static int brother;
    private static Integer[] isVisited = new Integer[100001];
    private static int[] moveLocation = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());

        if (subin == brother) {
            System.out.println(0);
            System.out.println(subin);
            return;
        }
        
        isVisited[subin] = 0;
        bfs(subin);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(brother);
        for (int i = brother; ; ) {
            if (i == subin) {
                break;
            }
            answer.add(moveLocation[i]);
            i = moveLocation[i];
        }
        
        for (int i = answer.size() - 1; i >= 0; i--) {
            System.out.print(answer.get(i));
            System.out.print(" ");
        }

    }

    private static void bfs (int location) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(location);

        while (!queue.isEmpty()) {
            int curLocation = queue.poll();
            int[] dx = {-1, 1, curLocation};

            for (int i = 0; i < 3; i++) {
                int move = curLocation + dx[i];

                if (move == brother) {
                    System.out.println(isVisited[curLocation] + 1);
                    moveLocation[move] = curLocation;
                    return;
                }

                if (move < 0 || move >= isVisited.length) continue;
                if (isVisited[move] != null) continue;

                queue.add(move);
                isVisited[move] = isVisited[curLocation] + 1;
                moveLocation[move] = curLocation;
            }
        }
    }
}
