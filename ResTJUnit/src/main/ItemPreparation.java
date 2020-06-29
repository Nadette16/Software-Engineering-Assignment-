package main;

public class ItemPreparation extends item {
	private short cooksAvailable;
	@SuppressWarnings("unused")
	private int preparationTime;
	
	//constructor
	public ItemPreparation() {
		cooksAvailable = 4;
	}
	
	//returns available cooks
	public int getAvailableCooks() {
		return this.cooksAvailable;
	}
	
	/*public void prepareItem(String itemName) {
		if(getAvailableCooks() > 0) {
			cooksAvailable--;
		}
		else {
			System.out.println("No cook is available. Kindly wait");
		}
	}*/

	public Object getPreparationTime() {
		// TODO Auto-generated method stub
		return null;
	}
}

