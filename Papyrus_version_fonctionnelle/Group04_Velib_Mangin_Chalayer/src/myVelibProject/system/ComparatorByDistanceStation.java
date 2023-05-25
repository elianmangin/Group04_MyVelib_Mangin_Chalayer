package Group04_Velib_Mangin_Chalayer.system;
import java.util.Comparator;

public class ComparatorByDistanceStation implements Comparator<DockingStation>{
	protected Coordinates coordinates;
	
	public ComparatorByDistanceStation(Coordinates coordinates) {
		super();
		this.coordinates = coordinates;
	}
	
	@Override
	public int compare(DockingStation o1, DockingStation o2) {
		 
		double distance1 =  coordinates.distance(o1.getGps());
		double distance2 =  coordinates.distance(o2.getGps());
		
		if (distance1>distance2) {return 1;}
		if (distance1<distance2) {return -1;}
		else{return 0;}
	}
}
