package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock{
    private int damageOverTime;
    public PoisonRock(int dmg,int dot){
        super(dmg);
        setDamageOverTime(dot);
    }

    public void setDamageOverTime(int dot){
        this.damageOverTime = Math.max(0,dot);
    }

    public int getDamageOverTime(){
        return damageOverTime;
    }

    @Override
    public int dealDamage(Zombie zombie) {
        zombie.setDecay(zombie.getDecay() + getDamageOverTime());
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
        System.out.println("Poison Rock (" + getDamage() +", DoT = "
                +getDamageOverTime() +")");
        return "Poison Rock (" + getDamage() +", DoT = " +getDamageOverTime() +")" ;
    }
}
