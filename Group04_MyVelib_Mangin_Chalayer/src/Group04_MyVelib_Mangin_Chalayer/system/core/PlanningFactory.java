package Group04_MyVelib_Mangin_Chalayer.system.core;

/**
 * Factory of RidePlanning
 * @see RidePlanning
 * @see StandardRidePlanning
 */
public class PlanningFactory {
	/** Creates a RidePlanning for a given planning method ("standard").*/
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
