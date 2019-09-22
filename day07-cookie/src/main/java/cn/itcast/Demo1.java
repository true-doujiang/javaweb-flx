package cn.itcast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {

        List arraylist = new ArrayList();
        arraylist.add("a");
        arraylist.add("b");
        arraylist.add("c");
        arraylist.add("a");
        System.out.println(arraylist);

        LinkedList linked = new LinkedList(arraylist);
        linked.remove("a"); //Removes the first occurrence of the specified element from this list,
        linked.removeLast();//Removes and returns the last element from this list.
        linked.add(new Person());
        linked.addLast("addlast");
        linked.addFirst("addfirst");
        linked.addAll(arraylist); //区别于add()
        System.out.println(linked.contains("c"));
        System.out.println(linked.contains(new Person()));
        System.out.println(linked);
    }

}
