package Group04_MyVelib_Mangin_Chalayer.system.core;

/**
 * Factory of CostStrategy
 */
public class CostFactory {
	/** Creates a CostStrategy for a given card type.*/
	public CostStrategy create(String cardType) throws GeneralException{
		if(cardType == null){
			return new NoCardStrategy();
		}

		else if(cardType.equalsIgnoreCase("VLIBRE")){
			return new VlibreStrategy();
		}

		else if(cardType.equalsIgnoreCase("VMAX")){
			return new VmaxStrategy();
		}

		else {
			throw new GeneralException("Warning : Unsupported card type ("+cardType+")");
		}
	}
}