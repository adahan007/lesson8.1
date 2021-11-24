package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Antman extends Hero {


    public Antman(int health, int damage, String name) {
        super(health, damage, SuperAbility.HPBIGLITTLE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean foxi = RPG_Game.random.nextBoolean();
        if (foxi) {
            this.setHealth(this.getHealth() + 100);
            this.setDamage(this.getDamage() + 10);
            System.out.println("foxi увеличил себя на 50 %: ");

        }else{
            this.setDamage(this.getDamage() - 10);
            this.setHealth(this.getHealth() - 100);
            System.out.println("foxi уменьшил себя на 50 %: ");
        }

    }
}
