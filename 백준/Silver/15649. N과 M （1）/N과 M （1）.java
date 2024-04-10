import java.util.*;
import java.io.*;

public class Main {
    private static int[] numArr;
    private static boolean[] isVisited;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str.split(" ")[0]);
        int size = Integer.parseInt(str.split(" ")[1]);
        
        numArr = new int[size];
        isVisited = new boolean[num];
        
        dfs(num, size, 0);
        System.out.println(sb);
    }
    
    private static void dfs(int num, int size, int depth) {
        if (depth == size) {
            for (int a : numArr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0; i < num; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                numArr[depth] = i + 1;
                dfs(num, size, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}