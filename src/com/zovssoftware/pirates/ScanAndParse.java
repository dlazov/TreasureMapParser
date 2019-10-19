package com.zovssoftware.pirates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ScanAndParse {
    private static int WALK_SPEED = 3;
    private static int RUN_SPEED = 6;
    private static int HORSE_TROT = 4;
    private static int HORSE_GALLOP = 15;
    private static int ELEPHANT_RIDE = 6;
    private int count = 0;
    private LinkedList<String> list;

    public static void parseData(LinkedList<String> list, int size, int count) {
        if (!list.isEmpty()) {
            int speed = 0;
            String listNormalized = list.get(count).toLowerCase();
            if (listNormalized.contains("walk")) {
                speed = WALK_SPEED;
                System.out.println("Speed is now: " + speed);
            } else if (listNormalized.contains("run")) {
                speed = RUN_SPEED;
                System.out.println("Speed is now: " + speed);
            } else if (listNormalized.contains("horse trot")) {
                speed = HORSE_TROT;
                System.out.println("Speed is now: " + speed);
            } else if (listNormalized.contains("horse gallop")) {
                speed = HORSE_GALLOP;
                System.out.println("Speed is now: " + speed);
            } else if (listNormalized.contains("elephant ride")) {
                speed = ELEPHANT_RIDE;
                System.out.println("Speed is now: " + speed);
            } else {
                System.out.println("\nYe got th' wrong booty map Matie! Ye used: " + list.get(count).toString());
                System.out.println("Try changin' yer booty map in th' followin' ways!");
                System.out.println("Mode o' transport: [Walk, Run, Horse trot, Horse gallop or Elephant ride]");
                System.out.println("Time o' travel in minutes: [5, 10, 20]");
                System.out.println("Direction o' travel: [N,S,E,W]\n");
            }
        }
    }

    public int getCount() {
        return count;
    }

    public LinkedList<String> getList() {
        return list;
    }

    public ScanAndParse invoke() {
        String content = new String();
        File file = new File("loot.map");
        list = new LinkedList<String>();

        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            sc.useDelimiter(",");
            while (sc.hasNextLine()){
                content = sc.nextLine();
                list.add(content);
            }
            sc.close();
        } catch(FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nTh' booty map was no good, try again");
        }
        return this;
    }

}
