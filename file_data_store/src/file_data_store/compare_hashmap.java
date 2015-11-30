package file_data_store;

import java.util.*;

public class compare_hashmap {
    static HashMap combo (int n) {
        HashMap result = new HashMap(100);

        for (int j=1; j < n; j++) {
            for (int i=1; i <= n; i++) {
                int m = ((i+j)-1) % n +1;
                if (i < m){ 
                    int[] v= {i,m};
                    result.put(i+ ","+ m, v);
                }
            }
        }
        return result;
    }

    static HashMap combo2 (int n) {
        HashMap result = new HashMap(100);

        for (int j=1; j <= n; j++) {
            for (int i=1; i < j; i++) {
                int[] v= {i,j};
                result.put(i+ ","+ j, v);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap result = new HashMap(100);
        HashMap result2 = new HashMap(100);
        result = combo(5);
        result2 = combo2(5);
        if (result.keySet().equals(result2.keySet() )) {
            System.out.println("keySet equal: Y");
        } else{
            System.out.println("keySet equal: N");
        }

        if (result.equals(result2 )) {
            System.out.println("HashMap equal: Y");
        } else{
            System.out.println("HashMap equal: N");
        }

        System.out.println(result.toString());
        System.out.println(result2.toString());
    }
}
