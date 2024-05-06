import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        int[] levels = new int[people];
        for (int i = 0; i < people; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(levels);

        int minusPeople = (int) Math.round(people * 0.15);
        people = people - (minusPeople * 2);

        int firstIdx = 0;
        int lastIdx = levels.length - 1;
        while (minusPeople != 0) {
            levels[firstIdx++] = 0;
            levels[lastIdx--] = 0;
            minusPeople--;
        }

        double sum = 0;
        for (int i = 0; i < levels.length; i++) {
            if (levels[i] != 0) sum += levels[i];
        }

        System.out.println(Math.round(sum / people));
    }
}
