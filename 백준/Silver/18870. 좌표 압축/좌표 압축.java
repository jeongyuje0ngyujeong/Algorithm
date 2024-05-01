import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        IdxValue[] stdArr = new IdxValue[size];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            stdArr[i] = new IdxValue(Integer.parseInt(st.nextToken()), i, 0);
        }

        Arrays.sort(stdArr);
        for (int i = 1; i < stdArr.length; i++) {
            if (stdArr[i - 1].value == stdArr[i].value) {
                stdArr[i].newValue = stdArr[i - 1].newValue;

            } else {
                stdArr[i].newValue = stdArr[i - 1].newValue + 1;

            }
        }

        Arrays.sort(stdArr, (Comparator.comparingInt(o -> o.idx)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stdArr.length; i++) {
            sb.append(stdArr[i].newValue).append(" ");
        }

        System.out.println(sb);
    }
}

class IdxValue implements Comparable<IdxValue> {
    int idx;
    int value;
    int newValue;

    public IdxValue(int value, int idx, int newValue) {
        this.idx = idx;
        this.value = value;
        this.newValue = newValue;
    }

    @Override
    public int compareTo(IdxValue other) {
        if (this.value < other.value) {
            return -1;

        } else if (this.value == other.value) {
            return 0;

        } else return 1;
    }
}
