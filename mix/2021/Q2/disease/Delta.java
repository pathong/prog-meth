package disease;

import util.SevereLevel;

public class Delta extends Covid19{
    private int spikeProtein;

    public Delta(){
        setR0(5,7);
        setSpikeProtein(10);
        setCountryOfFirstAppearance("India");
    }

    @Override
    public SevereLevel severeLevel(boolean isVacinate) {
        if(isVacinate){
            return SevereLevel.MildOrLess;
        }
        else{
            return SevereLevel.SevereIllness;
        }
    }

    @Override
    public String toString() {
        return "Delta";
    }

    public void setSpikeProtein(int spikeProtein){
        this.spikeProtein = spikeProtein;
    }
    public int getSpikeProtein(){return this.spikeProtein;}

}
