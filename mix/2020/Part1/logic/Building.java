package logic;

import java.util.ArrayList;

public class Building {
	private ArrayList<EnterProfile> enterProfileList;

	private int populationCount = 0;
	private int potentialInfectedCount = 0;
	
	public Building() {
		enterProfileList = new ArrayList<EnterProfile>();
	}

	public EnterProfile addProfile(Person person, int temperature) {
		//Fill Code Here
		/*
		 * 	Create enterProfile with this person and temperature value as bodyTemperature, and add to this building.
			Check if building already has this person in enterProfileList. If has, remove the old one 
			Hint : Look at method below this one
			Increase populationCount by 1 and if enterProfile hasFever is true, Increase potentialInfectedCount by 1.
		 */

		boolean isFound = false;
		int indexFound = -1;
		EnterProfile toEnter = new EnterProfile(person, temperature);
		for(int i =0;i<getEnterProfileList().size();i++){
			if(getEnterProfileList().get(i).getPerson() == person){
				indexFound = i;
				isFound = true;
				break;
			}
		}
		if(isFound){
			removeProfile(indexFound);
		}
		getEnterProfileList().add(toEnter);
		populationCount++;
		if(toEnter.hasFever()){potentialInfectedCount++;}
		return toEnter;
	}
	
	
	public EnterProfile removeProfile(int index) {
		//Fill Code Here
		/*
		 * 	Remove enterProfile from enterProfileList according to the index number. 
			Decrease populationCount by 1 and if that enterProfile hasFever is true, Decrease potentialInfectedCount by 1.
		 */
		EnterProfile profileToRemove = getEnterProfileList().get(index);
		getEnterProfileList().remove(index);
		populationCount--;
		if(profileToRemove.hasFever()){potentialInfectedCount--;}
		return profileToRemove;
	}
	


	public int getPopulationCount() {
		return populationCount;
	}

 

	public int getPotentialInfectedCount() {
		return potentialInfectedCount;
	}

	public ArrayList<EnterProfile> getEnterProfileList() {
		return enterProfileList;
	}
}
