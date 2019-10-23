package info5100a6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class q3 {
	 public boolean uniqueOccurrences(int[] arr) {
	       Map<Integer,Integer> d = new HashMap<>();
	        for(int a: arr)
	            d.put(a, d.getOrDefault(a, 0) + 1);
	        return d.size() == new HashSet<>(d.values()).size();
	    }
}
