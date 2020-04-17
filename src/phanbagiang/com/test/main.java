package phanbagiang.com.test;

import java.util.HashSet;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		HashSet<String>set=new HashSet<String>();
		 
        // Adding elements into HashSet using add()
        set.add("Bình");
        set.add("An");
        set.add("Hạnh");
        set.add("Phúc");
        set.add("Giải");
        set.add("Thoát");
        
        
        // Displaying the HashSet
        for(String x :set) {
        	if(x.equalsIgnoreCase("Giải")) {
        		System.out.println(x);
        	}
        }
        
        //System.out.println(set.equals("Giải"));
        /*
        System.out.println("========================");
        System.out.println("List contains HGA or not:" +
                set.contains("1"));
        
        // Removing items from HashSet using remove()
        System.out.println("========================");
        set.remove("HGA");
        System.out.println("List after removing HGA:" + set);
        
        // Insert items
        System.out.println("========================");
        
        // Iterating over hash set items
         * */
        System.out.println("========================");
        System.out.println("Iterating over list:");
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
        	String x= i.next();
            System.out.println(x);
        }
        
        System.out.println("========================");
        System.out.println("for over list:");
        for(String x:set) {
        	System.out.println(x);
        }
	}

}
