import java.util.*;

class Solution {
    public static int count = 0;

    public static int[] solution(String today, String[] terms, String[] privacies) {

        HashMap<String, String> splitTerms = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            splitTerms.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String privacyDate = privacies[i].split(" ")[0];
            String privacyTerms = privacies[i].split(" ")[1];

            int expirationDate = Integer.parseInt(splitTerms.get(privacyTerms)) * 28;
            int todaySum = (Integer.parseInt(today.split("\\.")[0]) * 28 * 12)
                         + (Integer.parseInt(today.split("\\.")[1]) * 28)
                         + Integer.parseInt(today.split("\\.")[2]);
            int privacySum = (Integer.parseInt(privacyDate.split("\\.")[0]) * 28 * 12)
                           + (Integer.parseInt(privacyDate.split("\\.")[1]) * 28)
                           + expirationDate
                           + Integer.parseInt(privacyDate.split("\\.")[2]);

            if (todaySum >= privacySum) {
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}