package logic.card;

import logic.player.Player;

public class MageCard extends BaseCard{

    private Element mageType;

    public MageCard(String name, int power, int health, Element mageType){
        super(name,power,health);
        setMageType(mageType);
    }

    @Override
    public void play(Player player) {
        int count = 0;
        for(BaseCard card:player.getField()){
            if( card instanceof OrbCard){
                if(((OrbCard) card).getOrbType() == getMageType()){count++;}
            }
        }
        setPower(getPower() + count);
    }

    @Override
    public boolean canPlay(Player player) {
        for(BaseCard card:player.getField()){
            if( card instanceof OrbCard){
                if(((OrbCard) card).getOrbType() == getMageType()){return true;}
            }
        }
        return false;
    }

    public void setMageType(Element mageType){
        this.mageType = mageType;
    }

    public Element getMageType() {
        return mageType;
    }
}
