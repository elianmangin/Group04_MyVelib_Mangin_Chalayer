package myVelibProject;

public class CostFactory {
	public CostStrategy create(String cardType){
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
			System.out.println("Warning : Unsupported card type");
			return null;
		}
	}
}