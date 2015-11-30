package file_data_store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
//import java.util.LinkedHashMap;
import java.util.Map;

public class synch2 {// Synch2, captical first letter
    public static void main(String[] args) throws Exception { // public static Map<String, int> buildMap
        Map<String, String> map = new HashMap<String, String>();//<String, int> better
        BufferedReader in = new BufferedReader(new FileReader("D:/WangRen University Course Documents/DC1-sampleQueries.txt"));
        String line = "";
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("\t");// assume tab separated
            map.put(parts[0], parts[1]); // (parts[0], int)
        }
        in.close();
        
        //LinkedHashMap<Integer, String> lhmap = 
        //        new LinkedHashMap<Integer, String>();
        //Adding elements to LinkedHashMap
        //lhmap.put(22, "Abeya");
        
        System.out.println(map.toString());// change: output one by one, and a new function public static void mapOut
	}
}