package kg.geektech.game.general;

import kg.geektech.game.players.Bobik;
import kg.geektech.game.players.Druid;
import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(700, 50, "Tanos");
        Warrior warrior = new Warrior(260, 15, "Varvar");
        Medic doc = new Medic(230, 10, 15, "Aibolit");
        Berserk berserk = new Berserk(270, 20, "Bers");
        Magic magic = new Magic(250, 25, "Antimag");
        Medic assistant = new Medic(270, 15, 5, "Stajer");
        Antman antman = new Antman(200,20,"FOXI");
        Druid druid = new Druid(300,30,"Druid");
        Bobik bobik = new Bobik(200,40,"BOBIK");

        Hero[] heroes = new Hero[]{warrior, berserk, magic, doc, assistant, antman,druid, bobik};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        roundNumber++;
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesAppliesSuperAbilities(boss, heroes);
        printStatistics(boss, heroes);

    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
        }
    }

    private static void heroesAppliesSuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                heroes[i].applySuperPower(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println((roundNumber == 0 ? "BEFORE START" : roundNumber + " ROUND")
                + " _____________");
        System.out.println("Boss " + boss.getName() +
                " health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            /*System.out.println(heroes[i].getClass().getSimpleName() +
                    " health: " + heroes[i].getHealth()
                    + "[" + heroes[i].getDamage() + "]");*/
            System.out.println(heroes[i].getName() +
                    " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("_____________");
    }
}
