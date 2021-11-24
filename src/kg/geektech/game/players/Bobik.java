package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Bobik extends Hero {
    public Bobik(int health, int damage, String name) {
        super(health, damage, SuperAbility.OBMANSHIK, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean round = RPG_Game.random.nextBoolean();
        int obmanul = 100;
        for (int i = 0; i <heroes.length ; i++) {
            if (round == true && heroes[i].getHealth() > 0){
                boss.setHealth(boss.getHealth() - obmanul);
                i = RPG_Game.random.nextInt(heroes.length);
                heroes[i].setHealth(heroes[i].getHealth() + obmanul);
                System.out.println("забрал у босса хп [" + obmanul + "] ХП и отдал герою: [" + heroes[i].getName() + "]");
break;
            }

        }

    }
}
