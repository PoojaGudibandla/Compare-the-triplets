import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> ascore = new ArrayList<>();
        List<Integer> bscore = new ArrayList<>();
        List<Integer> totalscore = new ArrayList<>();
        int atotal=0,btotal=0;
        for (int i=0;i<a.size();i++)
        {
            if(a.get(i)<b.get(i)){
                ascore.add(i,0);
                bscore.add(i,1);
            }
            if(a.get(i)>b.get(i)){
                ascore.add(i,1);
                bscore.add(i,0);
            }
            if(a.get(i)==b.get(i)){
                ascore.add(i,0);
                bscore.add(i,0);
            }
        }
        for(int i=0;i<ascore.size();i++){
            atotal+=ascore.get(i);
        }
        for(int i=0;i<bscore.size();i++){
            btotal+=bscore.get(i);
        }
        totalscore.add(0,atotal);
        totalscore.add(1,btotal);
        return totalscore;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bTemp[i]);
            b.add(bItem);
        }

        List<Integer> result = Result.compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
