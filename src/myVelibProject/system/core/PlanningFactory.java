package myVelibProject.system.core;

public class PlanningFactory {
	public RidePlanning create(String planning, MyVelib myVelib){
		if(planning == null){
			return null;
		}
		
		else if(planning.equalsIgnoreCase("STANDARD")){
			return new StandardRidePlanning(myVelib);
		} 
		
		else {
			System.out.println("Warning : no planning with this name exists");
			return null;
		}
	}

}
