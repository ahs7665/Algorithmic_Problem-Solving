import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        if(s == null || s.length() <= 1) return "YES";
        int[] counts = new int[26];

        for(char c : s.toCharArray()) {
            counts[c-'a']++;
        }

        HashMap<Integer, Integer> uniq = new HashMap<>();

        for(int count : counts) {
            int f = uniq.getOrDefault(count, 0);
            uniq.put(count, f+1);
        }

        if(uniq.size() > 3) return "NO";

        if(uniq.size() == 2) return "YES";

        int frq = 0;
        int c = 0;

        for(Map.Entry<Integer, Integer> m : uniq.entrySet()) {
            if(m.getKey() != 0 && m.getValue() > frq) {
                frq = m.getValue();
                c = m.getKey();
            }
        }

        for(Map.Entry<Integer, Integer> m : uniq.entrySet()) {
            if(m.getKey() != 0 && m.getKey() != c) {
                if(m.getValue() > 1) return "NO";
                else if(!uniq.containsKey(m.getKey() - 1)) return "NO";
            }
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
