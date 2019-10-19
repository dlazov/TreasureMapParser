package com.zovssoftware.pirates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

class ScanAndParse {
    private static int WALK_SPEED = 3;
    private static int RUN_SPEED = 6;
    private static int HORSE_TROT = 4;
    private static int HORSE_GALLOP = 15;
    private static int ELEPHANT_RIDE = 6;
    private LinkedList<String> list;
    private static double milesTraveled = 0.0;

    // Parses the input data by splitting the the string and doing logic checks on the split out data.
    // TODO: DGL - Append total miles, direction and speed to LinkedList.
    static void parseData(LinkedList<String> list, int count) {
        if (!list.isEmpty()) {
            String listNormalized = list.get(count).toLowerCase();
            String[] splitString = listNormalized.split(",", 0);
            int speed = 0;
            speed = getTravelSpeed(speed, splitString[0]);
            int time = 0;
            getMilesTraveled(speed, time, splitString[1]);
            getDirection(list.get(count), splitString[2]);
        }
        System.out.println("\n");
    }

    private static void getDirection(String s1, String s2) {
        String direction = "";
        if (s2.contains("n")) {
            direction = s2.toUpperCase();
        } else if (s2.contains("s")) {
            direction = s2.toUpperCase();
        } else if (s2.contains("e")) {
            direction = s2.toUpperCase();
        } else if (s2.contains("w")) {
            direction = s2.toUpperCase();
        } else {
            System.out.printf("\nYe got th' wrong booty map Matie! Ye used: %s%s%n", s1, direction);
            System.out.println("Try changin' yer booty map in th' followin' ways!");
            System.out.println("Direction o' travel: [N,S,E,W]\n");
        }
        System.out.println("Th' Current Direction be: " + direction.toUpperCase());
    }

    private static int getMilesTraveled(int speed, int timeTraveled, String stringTime) {
        try {
            timeTraveled = parseInt(stringTime);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        if (speed == WALK_SPEED) {
            milesTraveled = getMph(speed, timeTraveled);
        } else if (speed == RUN_SPEED) {
            milesTraveled = getMph(speed, timeTraveled);
        } else if (speed == HORSE_TROT) {
            milesTraveled = getMph(speed, timeTraveled);
        } else if (speed == HORSE_GALLOP) {
            milesTraveled = getMph(speed, timeTraveled);
        } else if (speed == ELEPHANT_RIDE) {
            milesTraveled = getMph(speed, timeTraveled);
        } else {
            System.out.println("\nYe got th' wrong booty map Matie! Ye used: " + stringTime);
            System.out.println("Try changin' yer booty map in th' followin' ways!");
            System.out.println("Time o' travel in minutes: [5, 10, 20]");
        }
        System.out.println("Th' miles traveled are " + milesTraveled + ", based on " + timeTraveled + " minutes of travel time.");
        return timeTraveled;
    }

    private static double getMph(int speed, int time) {
        int distance;
        double totalMilesTraveled;
        distance = speed * time;
        totalMilesTraveled = distance / 60.0;
        return totalMilesTraveled;
    }

    private static int getTravelSpeed(int speed, String mode) {
        if (mode.contains("walk")) {
            speed = WALK_SPEED;
        } else if (mode.contains("run")) {
            speed = RUN_SPEED;
        } else if (mode.contains("horse trot")) {
            speed = HORSE_TROT;
        } else if (mode.contains("horse gallop")) {
            speed = HORSE_GALLOP;
        } else if (mode.contains("elephant ride")) {
            speed = ELEPHANT_RIDE;
        } else {
            System.out.println("\nYe got th' wrong booty map Matie! Ye used: " + mode);
            System.out.println("Try changin' yer booty map in th' followin' ways!");
            System.out.println("Mode o' transport: [Walk, Run, Horse trot, Horse gallop or Elephant ride]");
        }
        System.out.println("Th' current mode o' transport be " + mode.toUpperCase() + " 'n th' current speed be: " + speed + "mph.");
        return speed;
    }

    int getCount() {
        return 0;
    }

    LinkedList<String> getList() {
        return list;
    }

    ScanAndParse invoke() {
        String content;
        /**
         * NOTE: use of these pre-loaded maps, only one at a time.
         * */
        // TODO: DGL - Load a file from the command line.
        File file = new File("loot.map");
//        File file = new File("all-loot.map");
//        File file = new File("bad-loot.map");
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
