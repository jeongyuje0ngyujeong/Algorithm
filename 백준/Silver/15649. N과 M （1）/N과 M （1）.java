import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> numList = new ArrayList<>();
    static boolean[] isVisited;
    static int maxNum = 0;
    static int length = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        maxNum = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        isVisited = new boolean[maxNum + 1];
        printNum(0);
        System.out.println(sb);
    }
    public static void printNum(int depth) {
        if (depth >= length) {
            for (int num : numList) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= maxNum; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                numList.add(i);
                printNum(depth + 1);
                isVisited[i] = false;
                numList.remove(numList.size() - 1);
            }
        }
    }
}