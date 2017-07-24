package ua.nure.bushuy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
	// write your code here
        MyListImpl con = new MyListImpl();
        con.add("A");
        con.add("B");
        con.add(433);
        con.add(888);
        con.add(new Object());
        con.add(null);
        System.out.println(con.toString());
        con.remove(433);
        System.out.println(con.toString());
        Object[] array = con.toArray();
        System.out.println(array.length);
        System.out.println("Is array? " + array.getClass().isArray());
        System.out.println("Size is:" + con.size());
        System.out.println("Contains value? " + con.contains(null));
        MyList con1 = new MyListImpl();
        con1.add("A");
        con1.add("B");
        System.out.println("Contains all items from another list: " + con.containsAll(con1));
        MyList con2 = new MyListImpl();
        con2.add("A");
        con2.add("C");
        System.out.println("Contains all items from another list: " + con.containsAll(con2));

        System.out.println(con.toString());
        Iterator<Object> iterator = con.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator<Object> iterator1 = con.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            if(obj != null && obj.equals("A")) {
                iterator1.remove();
            }
        }
        for(Object o : con) {
            System.out.println("Item is: " + o);
        }
        ListIterator listIterator = con.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            listIterator.set("Z");
        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());

        }
        con.clear();
        System.out.println(con.toString());


    }
    }


