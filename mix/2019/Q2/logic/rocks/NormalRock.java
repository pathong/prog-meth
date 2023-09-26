package logic.rocks;

import logic.zombies.Zombie;
import logic.zombies.ZombieManager;

public class NormalRock {
    protected int damage;


    public NormalRock(int damage){
        setDamage(damage);
    }

    public int dealDamage(Zombie zombie){
        if(zombie.getDefense() >= getDamage()){
            zombie.setHealth(zombie.getHealth());
            return 0;
        }
        else{
            zombie.setHealth(zombie.getHealth() - (getDamage() - zombie.getDefense()));
            return getDamage() - zombie.getDefense();
        }
    }





    @Override
    public String toString() {
        System.out.println("Normal Rock (" + getDamage() + ")");
        return "Normal Rock (" + getDamage() + ")";
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0,damage);
    }
}
