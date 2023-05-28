package system.core;

/**
 * Factory of CostStrategy
 * @see CostStrategy
 * @see NoCardStrategy
 * @see VlibreStrategy
 * @see VmaxStrategy
 */
public class CostFactory {
	/** Creates a CostStrategy for a given card type (null, "vlibre", "vmax").*/
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