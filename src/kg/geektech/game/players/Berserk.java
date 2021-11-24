package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        System.out.println("Berserk applies " + getAbility());
        int critic = RPG_Game.random.nextInt(4)+2;
    this.setDamage(this.getDamage() * critic);
        System.out.println("Warrior applies" + getAbility() + "["+critic+"]");
    }


}
