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
    private static int rate = 0;
    private LinkedList<String> list;

    public static void parseData(LinkedList<String> list, int size, int count) {
        if (!list.isEmpty()) {
            int speed = 0;
            String listNormalized = list.get(count).toLowerCase();
            String[] splitString = listNormalized.split(",", 0);
            for (int i = 0; i <= splitString.length; i++) {
                speed = getSpeed(list.get(count), speed, splitString[0]);
                int time = 0;
                for (String s : splitString) {
                    time = getTime(list, count, speed, splitString, time, s);
                }
                String direction = "";
                for (int k = 0; k <= splitString.length; k++) {
                    getDirection(list.get(count), splitString[2]);
                }
            }
        }
    }

    private static void getDirection(String s, String s2) {
        String direction;
        if (s2.contains("n")) {
            direction = s2.toUpperCase();
            System.out.println("Direction is now: " + direction);
        } else if (s2.contains("s")) {
            direction = s2.toUpperCase();
            System.out.println("Direction is now: " + direction);
        } else if (s2.contains("e")) {
            direction = s2.toUpperCase();
            System.out.println("Direction is now: " + direction);
        } else if (s2.contains("w")) {
            direction = s2.toUpperCase();
            System.out.println("Direction is now: " + direction);
        } else {
            System.out.println("\nYe got th' wrong booty map Matie! Ye used: " + s.toString());
            System.out.println("Try changin' yer booty map in th' followin' ways!");
            System.out.println("Direction o' travel: [N,S,E,W]\n");
        }
    }

    private static int getTime(LinkedList<String> list, int count, int speed, String[] splitString, int time, String s) {
        try {
            time = Integer.parseInt(splitString[1]);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        int distance = 0;
        if (speed == WALK_SPEED) {
            int minutes = 20;
            distance = speed * time;
            rate = minutes / distance;
            System.out.println("Miles traveled is: " + rate);
        } else if (speed == RUN_SPEED) {
            int minutes = 10;
            distance = speed * time;
            rate = minutes / distance;
            System.out.println("Miles traveled is: " + rate);
        } else if (speed == HORSE_TROT) {
            int minutes = 15;
            distance = speed * time;
            rate = minutes / distance;
            System.out.println("Miles traveled is: " + rate);
        } else if (speed == HORSE_GALLOP) {
            int minutes = 4;
            distance = speed * time;
            rate = minutes / distance;
            System.out.println("Miles traveled is: " + rate);
        } else if (speed == ELEPHANT_RIDE) {
            int minutes = 10;
            distance = speed * time;
            rate = minutes / distance;
            System.out.println("Miles traveled is: " + rate);
        } else {
            System.out.println("\nYe got th' wrong booty map Matie! Ye used: " + list.get(count).toString() + s);
            System.out.println("Try changin' yer booty map in th' followin' ways!");
            System.out.println("Time o' travel in minutes: [5, 10, 20]");
        }
        return time;
    }

    private static int getSpeed(String s, int speed, String s2) {
        if (s2.contains("walk")) {
            speed = WALK_SPEED;
            System.out.println("Speed is now: " + speed);
        } else if (s2.contains("run")) {
            speed = RUN_SPEED;
            System.out.println("Speed is now: " + speed);
        } else if (s2.contains("horse trot")) {
            speed = HORSE_TROT;
            System.out.println("Speed is now: " + speed);
        } else if (s2.contains("horse gallop")) {
            speed = HORSE_GALLOP;
            System.out.println("Speed is now: " + speed);
        } else if (s2.contains("elephant ride")) {
            speed = ELEPHANT_RIDE;
            System.out.println("Speed is now: " + speed);
        } else {
            System.out.println("\nYe got th' wrong booty map Matie! Ye used: " + s.toString());
            System.out.println("Try changin' yer booty map in th' followin' ways!");
            System.out.println("Mode o' transport: [Walk, Run, Horse trot, Horse gallop or Elephant ride]");
        }
        return speed;
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
        list = new LinkedList<>();

        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            sc.useDelimiter(",");
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                list.add(content);
            }
            sc.close();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nTh' booty map was no good, try again");
        }
        return this;
    }

}
