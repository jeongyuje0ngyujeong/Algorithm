import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long people = Long.parseLong(br.readLine());
        long[] sizeTypePeople = new long[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            sizeTypePeople[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long shirtsBundle = Long.parseLong(st.nextToken());
        long pencilBundle = Long.parseLong(st.nextToken());

        long shirtsCnt = 0;
        for (int i = 0; i < 6; i++) {
            if (sizeTypePeople[i] % shirtsBundle == 0){
                shirtsCnt += (sizeTypePeople[i] / shirtsBundle);

            } else {
                shirtsCnt += (sizeTypePeople[i] / shirtsBundle)+ 1;
            }
        }

        long pencilBundleCnt = people / pencilBundle;
        long pencilCnt = people - (pencilBundleCnt * pencilBundle);

        System.out.println(shirtsCnt);
        System.out.println(pencilBundleCnt + " " + pencilCnt);
    }
}
