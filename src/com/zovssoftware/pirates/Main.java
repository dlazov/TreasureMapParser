package com.zovssoftware.pirates;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nMatie! th' map t' be scrutinized fer th' loot!\n");

        ScanAndParse scanAndParse = new ScanAndParse().invoke();
        LinkedList<String> list = scanAndParse.getList();

        Iterator i = list.iterator();
        int size = list.size();
        int count = scanAndParse.getCount();
        while (i.hasNext() && list.size() > count) {
            ScanAndParse.parseData(list, count);
            ++count;
        }

        for (String a : list) {
            System.out.println("These are th' steps to ye loot: " + a.toUpperCase());
        }
        System.out.println();
    }
}
