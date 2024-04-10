import java.util.*;

class Solution {
    public static StringTokenizer st;
    public static int count = 0;

    public int[] solution(String today, String[] terms, String[] privacies) {
        String[][] splitTerms = termsSet(terms);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            String privacyDate = st.nextToken(privacies[i]);
            String privacyTerms = st.nextToken(privacies[i]);

            for (int j = 0; j < terms.length; j++) {
                if (splitTerms[i][0].equals(privacyTerms)) {
                    st = new StringTokenizer(privacyDate, ".");
                    int year = Integer.parseInt(st.nextToken());
                    int month = Integer.parseInt(st.nextToken());
                    int day = Integer.parseInt(st.nextToken());

                    if (day == 1) {
                        day = 28;
                        month = 12 % (month + 1 + Integer.parseInt(splitTerms[i][1]));
                        year += 12 / (month + Integer.parseInt(splitTerms[i][1]));
                        sb.append(dateCheck(today, year, month, day, i)).append(" ");

                    } else {
                        day -= 1;
                        month = 12 % (month + Integer.parseInt(splitTerms[i][1]));
                        year += 12 / (month + Integer.parseInt(splitTerms[i][1]));
                        sb.append(dateCheck(today, year, month, day, i)).append(" ");

                    }

                    break;
                }
            }
        }

        int[] answer = new int[count];
        int idx = 0;
        String sbStr = String.valueOf(sb);
        String[] sbStrArr = sbStr.split(" ");
        for (int i = 0; i < sbStrArr.length; i++) {
            if (sbStrArr[i].equals("-1")) continue;
            answer[idx++] = Integer.parseInt(sbStrArr[i]);
        }

        return answer;
    }

    private String[][] termsSet(String[] terms) {
        String[][] splitTerms = new String[terms.length][2];
        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i]);
            splitTerms[i][0] = st.nextToken();
            splitTerms[i][1] = st.nextToken();

        }
        return splitTerms;
    }

    private int dateCheck(String today, int year, int month, int day, int num) {
        st = new StringTokenizer(today, ".");
        int todayYear = Integer.parseInt(st.nextToken());
        int todayMonth = Integer.parseInt(st.nextToken());
        int todayDay = Integer.parseInt(st.nextToken());

        if (todayYear > year) {
            count++;
            return num + 1;

        } else if (todayYear == year && todayMonth > month) {
            count++;
            return num + 1;

        } else if (todayDay == year && todayMonth == month && todayDay > day) {
            count++;
            return num + 1;

        }

        return -1;
    }

}