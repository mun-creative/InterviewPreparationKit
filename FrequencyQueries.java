import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {

    // Complete the freqQuery function below.
   static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> res=new ArrayList<Integer>();
        HashMap<Integer,Integer> hMap=new HashMap<Integer,Integer>();
        for(int i=0;i<queries.size();i++)
        {
            List<Integer> ls=new ArrayList<>(queries.get(i));
            Integer ele=ls.get(1);
            if(ls.get(0)==1)
            {
                 
                if(hMap.containsKey(ls.get(1)))
                {
                   
                    hMap.replace(ele,hMap.get(ele)+1);
                }
                else
                {
                    hMap.put(ele,0);
                }
            }
            else if(ls.get(0)==2)
            {
                if(hMap.containsKey(ele))
                {
                    if(hMap.get(1)==1)
                    {
                        hMap.remove(ele);
                    }
                    else{
                    hMap.replace(ele,hMap.get(ele)-1);
                    }
                }
            }
            else{
                ArrayList<Integer> lst=new ArrayList<>(hMap.values());
                if(lst.contains(ele))
                {
                    res.add(1);
                }
                else
                {
                    res.add(0);
                }
            }

        }
        return res;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            bufferedWriter.write(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
