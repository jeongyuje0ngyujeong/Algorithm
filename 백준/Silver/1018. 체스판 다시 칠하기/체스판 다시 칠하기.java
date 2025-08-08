import java.util.*;
import java.io.*;

public class Main {
    private static int minCnt = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        boolean[][] board = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String rowColor = br.readLine();
            for (int j = 0; j < col; j++) {
                if (rowColor.charAt(j) == 'W') {
                    board[i][j] = true;
                }
            }
        }
        int newRow = row - 7;
        int newCol = col - 7;
        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newCol; j++) {
                findMaxCnt(board, i, j);
            }
        }
        System.out.println(minCnt);
    }

    private static void findMaxCnt(boolean[][] board, int row, int col) {
        boolean checkColor = board[row][col];
        int checkCnt = 0;
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if (board[i][j] != checkColor) checkCnt++;
                checkColor = !checkColor;
            }
            checkColor = !checkColor;
        }
        checkCnt = Math.min(checkCnt, 64 - checkCnt);
        minCnt = Math.min(minCnt, checkCnt);
    }
}
