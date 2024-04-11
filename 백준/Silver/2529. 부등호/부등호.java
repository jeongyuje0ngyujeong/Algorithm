import java.io.*;

public class Main {
    private static int signSize;
    private static int[] arr;
    private static  String[] signArr;
    private static boolean[] isVisited;
    private static long max = -1;
    private static long min = 9999999999L;


    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        signSize = Integer.parseInt(br.readLine());
        arr = new int[signSize + 1];
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
            for (int i : arr) {
                sb.append(i);
            }

            long checkNum = Long.parseLong(sb.toString());
            if(checkNum > max) max = checkNum;
            if(checkNum < min) min = checkNum;
            sb = new StringBuilder();
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!isVisited[i]) {
                arr[depth] = i;
                isVisited[i] = true;
                if (depth == 0) dfs(depth + 1);
                else if (depth <= signSize && check(arr[depth - 1], arr[depth], signArr[depth - 1])) dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean check(int a, int b, String c) {
        if (c.equals(">")) {
            if (a < b) return false;
        } else {
            if (a > b) return false;
        }

        return true;
    }
}
