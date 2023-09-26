package logic.monster;

import logic.attack.Attack;

public class Leader extends Monster{
    private int maxChargeTurns;


    private int currentChargeTurns;
    private boolean isGuard;

    public Leader(String name, int hp, int def, int sp_def, Attack attack, int changeTurns) {
        super(name, hp, def, sp_def, attack);
        setMaxChargeTurns(changeTurns);
        setCurrentChargeTurns(0);
    }

    public boolean isReady(){
        return getCurrentChargeTurns() >= getMaxChargeTurns();
    }


    public int takeDamage(Attack attack){
        if(isGuard){return 0;}

        if(attack.isLeader()){
            setHp(getHp() - attack.calculateDamage(this));
            if(getHp() <=0){isDead = true;}
            return attack.calculateDamage(this);
        }
        else{
            setHp(getHp() - (int)Math.ceil(attack.calculateDamage(this)*.5));
            if(getHp() <=0){isDead = true;}
            return (int)Math.ceil(attack.calculateDamage(this)*.5);
        }
    }



    public int getMaxChargeTurns() {
        return maxChargeTurns;
    }

    public void setMaxChargeTurns(int maxChargeTurns) {
        this.maxChargeTurns = maxChargeTurns;
    }

    public boolean isGuard() {
        return isGuard;
    }

    public void setGuard(boolean guard) {
        isGuard = guard;
    }
    public int getCurrentChargeTurns() {
        return currentChargeTurns;
    }

    public void setCurrentChargeTurns(int currentChargeTurns) {
        this.currentChargeTurns = Math.max(0,Math.min(getMaxChargeTurns(), currentChargeTurns));
    }

}
