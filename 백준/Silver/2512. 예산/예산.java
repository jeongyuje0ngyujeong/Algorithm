import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        int[] budget = new int[cityNum];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityNum; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }

        int totalBudget = Integer.parseInt(br.readLine());
        Arrays.sort(budget);
        if (sum <= totalBudget) {
            System.out.println(budget[cityNum-1]);
            return;
        }

        int start = 1;
        int end = totalBudget;
        int check = (start + end) / 2;
        sum = 0;

        while (start <= end) {
            sum = 0;
            for (int i = 0; i < cityNum; i++) {
                if (budget[i] <= check) {
                    sum += budget[i];
                } else {
                    sum += check;
                    if (sum > totalBudget) {
                        break;
                    }
                }
            }

            if (sum > totalBudget) {
                end = check - 1;
                check = (start + end) / 2;

            } else if (sum < totalBudget) {
                start = check + 1;
                check = (start + end) / 2;

            } else {
                break;
            }
        }

        System.out.println(check);
    }
}
