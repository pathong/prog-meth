package logic.card;

import logic.player.Player;

import java.lang.management.ManagementFactory;

public abstract class BaseCard {
    private String name;
    private int power;
    private int health;

    public BaseCard(String name, int power,int health){
        setname(name);
        setPower(power);
        setHealth(health);
    }
    public abstract void play(Player player);

    public abstract boolean canPlay(Player player);

    public int attack(BaseCard target){
        int diff = getPower()-target.getHealth();
        target.setHealth(target.getHealth() - getPower());
        return Math.max(diff, 0);
    }


    public void setPower(int power){
        this.power = Math.max(0,power);
    }
    public void setHealth(int health){
        this.health= Math.max(0,health);
    }
    public void setname(String name){
        this.name = name;
    }

    public int getPower(){return this.power;}
    public int getHealth(){return this.health;}
    public String getName(){return this.name;}


}
