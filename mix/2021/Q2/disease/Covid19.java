package disease;

import util.SevereLevel;
import util.R0;

public class Covid19 extends Disease{

    private R0 reproductionNumber;
    private String countryOfFirstAppearance;

    public Covid19(){
        setR0(2,3);
        setCountryOfFirstAppearance("China");
    }
    @Override
    public SevereLevel severeLevel(boolean isVacinate) {
        if(isVacinate){
            return SevereLevel.Less;
        }
        else{
            return SevereLevel.SevereIllness;
        }
    }

    public int minimumInfectionSpread(int n){
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += (int)Math.pow(getReproductionNumber().getMin(), i);
        }
        return sum;
    }

    public String toString(){
        return "Covid19";
    }

    public void setR0(int min, int max){
        this.reproductionNumber = new R0(min,max);
    }
    public void setCountryOfFirstAppearance(String cunt){
        this.countryOfFirstAppearance= cunt;
    }

    public R0 getReproductionNumber(){return reproductionNumber;}
    public String getCountryOfFirstAppearance(){return countryOfFirstAppearance;}
}
