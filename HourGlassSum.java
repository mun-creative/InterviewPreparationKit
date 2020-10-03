import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int R = 6; 
static int C = 6; 
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] mat) {
        if (R < 3 || C < 3) 
        return -1; 
  
    // Here loop runs (R-2)*(C-2)  
    // times considering different 
    // top left cells of hour glasses. 
    int max_sum = Integer.MIN_VALUE; 
    for (int i = 0; i < R - 2; i++) 
    { 
        for (int j = 0; j < C - 2; j++) 
        { 
            // Considering mat[i][j] as top  
            // left cell of hour glass. 
            int sum = (mat[i][j] + mat[i][j + 1] +  
                       mat[i][j + 2]) + (mat[i + 1][j + 1]) +  
                       (mat[i + 2][j] + mat[i + 2][j + 1] +  
                       mat[i + 2][j + 2]); 
  
            // If previous sum is less then  
            // current sum then update 
            // new sum in max_sum 
            max_sum = Math.max(max_sum, sum); 
        } 
    } 
    return max_sum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
