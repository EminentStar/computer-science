import java.util.ArrayList;

/**
 * Created by eminentstar on 2017. 4. 3..
 */
public class Kmp {

    public static ArrayList<Integer> kmp(String s, String p){
        ArrayList<Integer> matches = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int pi[] = getPi(p);

        int j = 0;

        for(int i = 0; i < sLen ; i++){
            while(j > 0 && s.charAt(i) != p.charAt(j)){
                j = pi[j - 1];
            }

            if(s.charAt(i) == p.charAt(j)){
                if(j == pLen - 1){
                    matches.add(i - pLen + 1);
                    // j = 0; // mistake!
                    j = pi[j]; // Correct!!!!!!
                }else{
                    j++;
                }
            }
        }

        return matches;
    }

    public static int[] getPi(String p){
        int len = p.length();
        int[] pi = new int[len];
        int j = 0;

        for(int i = 1; i < len ; i++){
            while(j > 0 && p.charAt(i) != p.charAt(j)){
                j = pi[j -1];
            }

            if(p.charAt(i) == p.charAt(j)){
                pi[i] = ++j;
            }
        }

        return pi;
    }
}

