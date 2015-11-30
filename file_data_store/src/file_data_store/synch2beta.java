package file_data_store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class synch2beta {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader in = new BufferedReader(new FileReader("D:/WangRen University Course Documents/DC2-sampleQueries.txt"));
        String line = "";
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("\t"); // assume tab separated
            map.put(parts[0], parts[1]);
        }
        in.close();
        
        System.out.println(map.toString());
    }
}