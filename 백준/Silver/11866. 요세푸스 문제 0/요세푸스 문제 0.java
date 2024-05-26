import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int numOfPeople = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        
        boolean[] peopleArr = new boolean[numOfPeople];
        boolean isPeopleArrTrue = false;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int checkIdx = 0;
        
        while (!isPeopleArrTrue) {
            for (int i = 0; i < numOfPeople; i++) {
                checkIdx++;
                if (!peopleArr[i]) {
                    if (checkIdx % order == 0) {
                        peopleArr[i] = true;
                        sb.append(i + 1).append(", ");
                    }
                } else checkIdx--; 
            }
            
            for (boolean isOut : peopleArr) {
                isPeopleArrTrue = isOut;
                if (!isOut) break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");
        System.out.println(sb);
    }
}