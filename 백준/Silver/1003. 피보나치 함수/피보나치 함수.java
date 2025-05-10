import java.util.*;
import java.io.*;

public class Main {
     public static void main(String[] args) throws IOException {
         int[][] fibo = new int[41][2];
         fibo[0][0] = 1;
         fibo[1][1] = 1;
         
         for (int i = 2; i < fibo.length; i++) {
             fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
             fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
         }
         
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
         int testCase = Integer.parseInt(br.readLine());
         
         for (int i = 0; i < testCase; i++) {
             int num = Integer.parseInt(br.readLine());
             sb.append(fibo[num][0]).append(" ").append(fibo[num][1]);
             System.out.println(sb);
             sb.setLength(0);
         }
     }
}