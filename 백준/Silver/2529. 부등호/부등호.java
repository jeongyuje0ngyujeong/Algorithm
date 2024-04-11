import java.io.*;

public class Main {
    private static int signSize;
    private static  String[] signArr;
    private static boolean[] isVisited;
    private static long max = -1;
    private static long min = 9999999999L;
    private static  long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        signSize = Integer.parseInt(br.readLine());

        signArr = br.readLine().split(" ");
        isVisited = new boolean[10];

        dfs(0);
        System.out.println(max);
        if (String.valueOf(min).length() < signSize + 1) {
            System.out.println("0" + min);
        } else System.out.println(min);

    }

    private static void dfs(int depth) {
        if (depth > signSize) {
            if(answer > max) max = answer;
            if(answer < min) min = answer;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!isVisited[i]) {
                long prev = answer % 10;
                answer = answer * 10 + i;
                isVisited[i] = true;
                if (depth == 0) dfs(depth + 1);
                else if (check(prev, answer % 10, signArr[depth - 1])) dfs(depth + 1);
                isVisited[i] = false;
                answer /= 10;
            }
        }
    }

    private static boolean check(long a, long b, String c) {
        if (c.equals(">")) {
            return a > b;
        } else {
            return a < b;
        }
    }
}
