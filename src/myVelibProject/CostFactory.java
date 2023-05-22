package myVelibProject;

public class CostFactory {
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