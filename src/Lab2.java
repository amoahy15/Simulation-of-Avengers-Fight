/**
 * Author: Humphrey Amoakohene
 * This is my code that reads in a csv file and simulates a battle between these heros
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab2 {
    public static void battleSimple(ArrayList<Hero> heroArrayList1, ArrayList<Hero> heroArrayList2) throws FileNotFoundException {
        //Scanner
        Scanner scnr = new Scanner(System.in);
        // For file input
        String inputFileName = scnr.nextLine();
        //Saving into stream
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream("src/" + inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);
        // ignore first line

        //Loop that reads csv file
        while (inputFileNameScanner.hasNext()) {
            //Parse information by commas
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");
            if (parts[4].equals("1")) {
                Hero heroToAdd = new Hero(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                //Add to ArrayList
                heroArrayList1.add(heroToAdd);

            } else if (parts[4].equals("2")) {
                Hero heroToAdd = new Hero(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                //Add to ArrayList
                heroArrayList2.add(heroToAdd);
            }
        }
        //Loop that print each fight
        for (int i = 0; i < heroArrayList1.size(); i++) {
            System.out.println(heroArrayList1.get(i).getName() + " VS. " + heroArrayList2.get(i).getName());
            //Loop that does battle
            while (true) {
                //Getting Hero 1  damage
                int attackDamage1 = heroArrayList1.get(i).attack();
                //Getting Hero 2  damage
                int attackDamage2 = heroArrayList2.get(i).attack();
                //Giving hero 2 damage to hero 1
                heroArrayList1.get(i).takeDamage(attackDamage2);
                //Giving hero 1 damage to hero 2
                heroArrayList2.get(i).takeDamage(attackDamage1);

                //Checking who wins
                if (heroArrayList1.get(i).getHitPoints() <= 0) {
                    System.out.println(heroArrayList2.get(i).getName() + " VANQUISHES " + heroArrayList1.get(i).getName() +
                            " with " + heroArrayList2.get(i).getHitPoints() + " HP to spare");
                    break;

                } else if (heroArrayList2.get(i).getHitPoints() <= 0) {
                    System.out.println(heroArrayList1.get(i).getName() + " VANQUISHES " + heroArrayList2.get(i).getName() +
                            " with " + heroArrayList1.get(i).getHitPoints() + " HP to spare");
                    break;
                } else if ((heroArrayList1.get(i).getHitPoints() <= 0) && (heroArrayList2.get(i).getHitPoints() <= 0)) {
                    System.out.println(heroArrayList1.get(i).getName() + " and " + heroArrayList2.get(i).getName() +
                            " are evenly matched");
                    break;
                }
            }
        }

    }


    public static void battleDetailed(ArrayList<Hero> heroArrayList1, ArrayList<Hero> heroArrayList2) throws FileNotFoundException {
        //Scanner
        Scanner scnr = new Scanner(System.in);
        String inputFileName = scnr.nextLine();

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream("src/" + inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();
        //While loop to read the file input
        while (inputFileNameScanner.hasNext()) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");
            if (parts[4].equals("1")) {
                Hero heroToAdd = new Hero(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                heroArrayList1.add(heroToAdd);

            } else if (parts[4].equals("2")) {
                Hero heroToAdd = new Hero(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                heroArrayList2.add(heroToAdd);
            }
        }

        for (int i = 0; i < heroArrayList1.size(); i++) {
            System.out.println(heroArrayList1.get(i).getName() + " VS. " + heroArrayList2.get(i).getName());
            System.out.println("============================================");
            while (true) {
                System.out.println(heroArrayList1.get(i).getName() + " has " + heroArrayList1.get(i).getHitPoints()
                        + " HP left");
                System.out.println(heroArrayList2.get(i).getName() + " has " + heroArrayList2.get(i).getHitPoints()
                        + " HP left");
                System.out.println("============================================");

                //Getting Hero 1  damage
                int attackDamage1 = heroArrayList1.get(i).attack();
                if (attackDamage1 == heroArrayList1.get(i).getLightATK()) {
                    System.out.println(heroArrayList1.get(i).getName() + " preforms a Light ATK with Damage: "
                            + heroArrayList1.get(i).getLightATK());
                } else {
                    System.out.println(heroArrayList1.get(i).getName() + " preforms a Heavy ATK with Damage: "
                            + heroArrayList1.get(i).getHeavyATK());

                }
                //Getting Hero 2  damage
                int attackDamage2 = heroArrayList2.get(i).attack();
                if (attackDamage2 == heroArrayList2.get(i).getLightATK()) {
                    System.out.println(heroArrayList2.get(i).getName() + " preforms a Light ATK with Damage: "
                            + heroArrayList2.get(i).getLightATK());
                } else {
                    System.out.println(heroArrayList2.get(i).getName() + " preforms a Heavy ATK with Damage: "
                            + heroArrayList2.get(i).getHeavyATK());

                }
                System.out.println("============================================");
                //Giving hero 2 damage to hero 1
                heroArrayList1.get(i).takeDamage(attackDamage2);
                //Giving hero 1 damage to hero 2
                heroArrayList2.get(i).takeDamage(attackDamage1);

                if (heroArrayList1.get(i).getHitPoints() <= 0) {
                    System.out.println(heroArrayList1.get(i).getName() + " has fainted");
                    System.out.println(heroArrayList2.get(i).getName() + " has " +
                            heroArrayList2.get(i).getHitPoints() + " HP to spare");
                    System.out.println("============================================");
                    System.out.println(heroArrayList2.get(i).getName() + " VANQUISHES " + heroArrayList1.get(i).getName() +
                            " with " + heroArrayList2.get(i).getHitPoints() + " HP to spare");
                    System.out.println("============================================");
                    break;

                } else if (heroArrayList2.get(i).getHitPoints() <= 0) {
                    System.out.println(heroArrayList2.get(i).getName() + " has fainted");
                    System.out.println(heroArrayList1.get(i).getName() + " has " +
                            heroArrayList1.get(i).getHitPoints() + " HP to spare");
                    System.out.println("============================================");
                    System.out.println(heroArrayList1.get(i).getName() + " VANQUISHES " + heroArrayList2.get(i).getName() +
                            " with " + heroArrayList1.get(i).getHitPoints() + " HP to spare");
                    System.out.println("============================================");
                    break;
                } else if ((heroArrayList1.get(i).getHitPoints() <= 0) && (heroArrayList2.get(i).getHitPoints() <= 0)) {
                    System.out.println(heroArrayList1.get(i).getName() + " and " + heroArrayList2.get(i).getName() +
                            " are evenly matched");
                    break;
                }

            }

        }
    }


    public static void main(String[] args) throws IOException {
        //Hero ArrayList
        ArrayList<Hero> heroArrayList1 = new ArrayList<Hero>();
        ArrayList<Hero> heroArrayList2 = new ArrayList<Hero>();

        //Receiving the command line argument
        Boolean printFlag = Boolean.parseBoolean(args[0]);

        //Catching exceptions
        try {
            if (printFlag == true) {
                battleDetailed(heroArrayList1, heroArrayList2);
            }
            if (printFlag == false) {
                battleSimple(heroArrayList1, heroArrayList2);
            }
        } catch (IOException e1) {
            System.out.println("the print flag is incorrectly set");
        }


    }
}



