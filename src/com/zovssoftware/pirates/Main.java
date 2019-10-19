package com.zovssoftware.pirates;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Matie! th' map t' be scrutinized fer th' loot!");

        ScanAndParse scanAndParse = new ScanAndParse().invoke();
        LinkedList<String> list = scanAndParse.getList();

        Iterator i = list.iterator();
        int size = list.size();
        int count = scanAndParse.getCount();
        while (i.hasNext() && list.size() > count) {
            ScanAndParse.parseData(list, size, count);
            ++count;
        }
        System.out.println("These are th' loot maps steps ye loot: " + list);
    }
}
