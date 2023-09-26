package logic.card;

import logic.player.Player;

public class RobotCard extends BaseCard{
    int energyCost;

    public RobotCard(String name, int power, int health, int energyCost){
        super(name, power, health);
        setEnergyCost(energyCost);
    }

    @Override
    public void play(Player player) {
        player.setEnergy(player.getEnergy() - energyCost);
    }

    @Override
    public boolean canPlay(Player player) {
        return player.getEnergy() >= getEnergyCost();
    }

    public void setEnergyCost(int cost){
        this.energyCost = Math.max(cost,0);
    }

    public int getEnergyCost(){return energyCost;}
}
