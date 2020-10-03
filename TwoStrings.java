import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        if((s1.length()<0 || s2.length()<0)|| (s1.length()>100000) || (s2.length()>100000))
        {
            return "NO";
        }
        Set<Character> hSet1=new HashSet<>();
        for(int i=0;i<s1.length();i++)
        {
            hSet1.add(s1.charAt(i));
        }
        Set<Character> hSet2=new HashSet<>();
        for(int i=0;i<s2.length();i++)
        {
            hSet2.add(s2.charAt(i));
        }
        hSet1.retainAll(hSet2);
        if(!hSet1.isEmpty())
        {
            return "YES";
        }
        else
        {
            return "NO";
        }
               
       
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
