import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num == 1) {
            System.out.println(1 + "/" + 1);
            return;
        }

        int T = 3;
        int box = 0;
        int boxesCnt = 1;

        for (int i = T; ; i++) {
            box = i - 1;
            boxesCnt += box;
            T = i;
            if (boxesCnt >= num) {
                boxesCnt = boxesCnt - box + 1;
                break;
            }
        }

        int child = 1;
        int parents = 1;

        if (T % 2 != 0) {
            parents = T - 1;

            if (boxesCnt + box == num) {
                System.out.println(child + "/" + parents);
                return;
            }

            for (int i = boxesCnt; i <= num; i++) {
                if (num == i) {
                    System.out.println(child + "/" + parents);
                    return;
                }
                child++;
                parents--;

            }

        } else {
            child = T - 1;

            if (boxesCnt + box == num) {
                System.out.println(child + "/" + parents);
                return;
            }

            for (int i = boxesCnt; i <= num; i++) {
                if (num == i) {
                    System.out.println(child + "/" + parents);
                    return;
                }
                parents++;
                child--;
            }
        }




    }
}
