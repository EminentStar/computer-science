import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = null;
        String p = null;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        s = bf.readLine();
        p = bf.readLine();

        ArrayList<Integer> matches = Kmp.kmp(s, p);

        int size = matches.size();

        System.out.println(size);
        for(int i = 0; i < size ; i++){
            System.out.println(matches.get(i) + 1);
        }

    }
}

