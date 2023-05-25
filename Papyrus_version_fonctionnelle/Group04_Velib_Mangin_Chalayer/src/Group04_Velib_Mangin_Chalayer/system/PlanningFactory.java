package Group04_Velib_Mangin_Chalayer.system;

public class PlanningFactory {
	
	public RidePlanning create(String planning, MyVelib myVelib) throws GeneralException{
		if(planning == null){
			return null;
		}
		
		else if(planning.equalsIgnoreCase("STANDARD")){
			return new StandardRidePlanning(myVelib);
		} 
		
		else throw new GeneralException("No planning of this name");
		}
	}


