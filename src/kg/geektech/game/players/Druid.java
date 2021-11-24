package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Druid extends Hero {
    public Druid(int health, int damage, String name) {
        super(health, damage,SuperAbility.PRIZYVE_VORONA_AND_ANGEL,name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int prizyvBoss = RPG_Game.random.nextInt(2);
        int angelXP = RPG_Game.random.nextInt(15) + 2;
        int bossXP = boss.getHealth() / 2;
        int bossDD = boss.getDamage() / 2;

        if (prizyvBoss == 1) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + angelXP);
                }
            }
            System.out.println(getName() + " призвал Ангела (" + angelXP + "xp)");
        } else {
            if (boss.getHealth() <= bossXP) {
                boss.setDamage(boss.getDamage() + bossDD);
                System.out.println(getName() + " призвал случайно Ворона + 50% BOSSDAMAGE");
            }
            if (boss.getHealth() >= bossXP) {
                System.out.println(getName() + " призвал случайно Ворона ");
            }
        }

    }
}



