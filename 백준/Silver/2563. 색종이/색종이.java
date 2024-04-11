import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int paperNum = Integer.parseInt(br.readLine());
        int[][] drawingPaper = new int[100][100];
        
        for (int i = 0; i < paperNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for (int j = h; j < h + 10; j++) {
                for (int k = w; k < w + 10; k++) {
                    if (drawingPaper[j][k] == 0) drawingPaper[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (drawingPaper[i][j] == 1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}
