import java.io.*;

public class Main {
    private static int size = 0;
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        isVisited = new boolean[size + 1];
        back_tracking(1, 0);
    }

    private static void back_tracking(int num, int depth) {
        if (depth == size) {
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= size; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sb.append(i).append(" ");
                back_tracking(i + 1, depth + 1);
                isVisited[i] = false;
                sb.delete(sb.length() - 2, sb.length());
            }
        }
    }
}
