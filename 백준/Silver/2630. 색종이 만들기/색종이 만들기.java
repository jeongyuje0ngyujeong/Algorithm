import java.io.*;
import java.util.*;


public class Main {
    static int size;
    static int[][] paper;
    static boolean[][] isVisited;
    static int whiteCnt = 0;
    static int blueCnt = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        paper = new int[size][size];
        boolean isSame = true;

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());

                if (j != 0 && paper[i][j - 1] != paper[i][j] && isSame) {
                    isSame = false;
                }
            }
        }

        if (isSame) {
            if (paper[0][0] == 0) {
                System.out.println(1);
                System.out.println(0);

            } else {
                System.out.println(0);
                System.out.println(1);

            }
            return;
        }

        findIt(0, size / 2, 0, size / 2);
        findIt(size / 2, size, 0, size / 2);
        findIt(0, size / 2, size / 2, size);
        findIt(size / 2, size, size / 2, size);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);


    }

    private static void findIt (int widSt, int widEn, int heiSt, int heiEn) {
        if (widEn < 1 || heiEn < 1 || widSt >= widEn || heiSt >= heiEn) {
            return;
        }
        boolean isSame = true;
        int checkNum = paper[heiSt][widSt];

        int width = widEn - widSt;
        int height = heiEn - heiSt;

        for (int i = heiSt; i < heiEn; i++) {
            for (int j = widSt; j < widEn; j++) {
                if (isSame && checkNum != paper[i][j]) {
                    isSame = false;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            if (checkNum == 0) {
                whiteCnt++;

            } else {
                blueCnt++;

            }

        } else {
            findIt(widSt, widSt + (width / 2), heiSt, heiSt + (height / 2));
            findIt(widSt + (width / 2), widEn, heiSt, heiSt + (height / 2));
            findIt(widSt, widSt + (width / 2), heiSt + (height / 2), heiEn);
            findIt(widSt + (width / 2), widEn, heiSt + (height / 2), heiEn);
        }
    }
}
