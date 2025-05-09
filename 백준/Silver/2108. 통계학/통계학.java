import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] nums = new int[num];
        long sum = 0;
        int min = 4000;

        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            if (min > nums[i]) min = nums[i];
        }

        System.out.println(avg(num, sum));
        System.out.println(center(nums));
        System.out.println(frequency(nums, min));
        System.out.println(range(nums));
    }

    private static int range(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - nums[0]);
    }

    private static int frequency(int[] nums, int min) {
        int[] counting = new int[8001];

        for (int i = 0; i < nums.length; i++) {
            counting[nums[i] + 4000]++;
        }

        int checkMax = -1;
        for (int i = 0; i < counting.length; i++) {
            if (checkMax < counting[i]) checkMax = counting[i];
        }

        int isSecond = 0;
        int answer = 0;
        for (int i = 0; i < counting.length; i++) {
            if (checkMax == counting[i]) {
                isSecond++;
                answer = i;
            }
            if (isSecond == 2) {
                answer = i;
                break;
            }
        }

        return answer - 4000;
    }

    private static int center(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }

    private static long avg(int num, long sum) {
        return Math.round(sum / (double) num);
    }
}
